package com.example.OnlineExamPlatform.controller;

import com.example.OnlineExamPlatform.entity.User;
import com.example.OnlineExamPlatform.request.AuthenticationRequest;
import com.example.OnlineExamPlatform.request.SignUpRequest;
import com.example.OnlineExamPlatform.response.AuthenticationResponse;
import com.example.OnlineExamPlatform.service.AuthService;
import com.example.OnlineExamPlatform.service.UserDetailServiceImpl;
import com.example.OnlineExamPlatform.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailServiceImpl userDetailService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getMail(), authenticationRequest.getPassword()));

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Yanlış kullanıcı adı ya da parola");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Kullanıcı oluşturulamadı, önce kullanıcıyı kaydedin.");
            return null;

        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getMail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return new AuthenticationResponse(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody SignUpRequest signUpRequest) {
        User user = authService.createUser(signUpRequest);
        return ResponseEntity.ok(user);
    }
}

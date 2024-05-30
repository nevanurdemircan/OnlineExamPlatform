package com.example.OnlineExamPlatform.service;

import com.example.OnlineExamPlatform.converter.UserConverter;
import com.example.OnlineExamPlatform.dto.RoleName;
import com.example.OnlineExamPlatform.dto.UserDto;
import com.example.OnlineExamPlatform.entity.Role;
import com.example.OnlineExamPlatform.entity.User;
import com.example.OnlineExamPlatform.repository.RoleRepository;
import com.example.OnlineExamPlatform.repository.UserRepository;
import com.example.OnlineExamPlatform.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserConverter converter;
    private final RoleRepository roleRepository;

    @Override
    public User createUser(SignUpRequest signUpRequest) {
        User user = converter.SignUpRequestConvertToUser(signUpRequest);

        Set<Role> roles = new HashSet<>();
        for (RoleName roleName : signUpRequest.getRoles()) {
            Optional<Role> roleOpt = Optional.ofNullable(roleRepository.findByRoleName(roleName));
            if (roleOpt.isPresent()) {
                roles.add(roleOpt.get());
            } else {
                Role role = Role.createRole(roleName);
                roleRepository.save(role);
                roles.add(role);
            }
        }

        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public UserDto getAuthUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findFirstByMail(principal.getUsername());
        UserDto userDto = converter.convertToUserDto(user);
        return userDto;
    }
}

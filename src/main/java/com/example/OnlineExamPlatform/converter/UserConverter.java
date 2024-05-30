package com.example.OnlineExamPlatform.converter;

import com.example.OnlineExamPlatform.dto.RoleName;
import com.example.OnlineExamPlatform.dto.UserDto;
import com.example.OnlineExamPlatform.entity.Role;
import com.example.OnlineExamPlatform.entity.User;
import com.example.OnlineExamPlatform.request.SignUpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class UserConverter {
    public UserDto convertToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setMail(user.getMail());

        return dto;
    }

    public User SignUpRequestConvertToUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setId(signUpRequest.getId());
        user.setName(signUpRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setMail(signUpRequest.getMail());

        for (RoleName roleName : signUpRequest.getRoles()) {
            Role role = new Role();
            role.setRoleName(roleName);
            user.getRoles().add(role);
        }
        return user;
    }
}
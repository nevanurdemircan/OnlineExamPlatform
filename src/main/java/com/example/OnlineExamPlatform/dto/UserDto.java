package com.example.OnlineExamPlatform.dto;

import com.example.OnlineExamPlatform.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String mail;
    private String password;
    private String name;
    private Long studentId;
    private List<Role> roles;
}

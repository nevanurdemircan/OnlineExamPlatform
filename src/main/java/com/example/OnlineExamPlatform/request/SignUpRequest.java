package com.example.OnlineExamPlatform.request;

import com.example.OnlineExamPlatform.dto.RoleName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private Long id;
    private String name;
    private String mail;
    private String password;
    private Long studentId;
    private Set<RoleName> roles;

}

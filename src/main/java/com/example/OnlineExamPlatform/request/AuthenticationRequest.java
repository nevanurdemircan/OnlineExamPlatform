package com.example.OnlineExamPlatform.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String mail;
    private String password;
}

package com.example.OnlineExamPlatform.service;

import com.example.OnlineExamPlatform.dto.UserDto;
import com.example.OnlineExamPlatform.entity.User;
import com.example.OnlineExamPlatform.request.SignUpRequest;

public interface AuthService {
    User createUser(SignUpRequest signUpRequest);
    UserDto getAuthUser();
}

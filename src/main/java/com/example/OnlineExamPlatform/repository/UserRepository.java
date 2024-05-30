package com.example.OnlineExamPlatform.repository;

import com.example.OnlineExamPlatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByMail(String email);
}

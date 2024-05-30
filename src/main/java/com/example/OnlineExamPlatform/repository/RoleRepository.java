package com.example.OnlineExamPlatform.repository;

import com.example.OnlineExamPlatform.dto.RoleName;
import com.example.OnlineExamPlatform.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}

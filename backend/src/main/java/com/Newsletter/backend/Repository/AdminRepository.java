package com.Newsletter.backend.Repository;

import com.Newsletter.backend.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    public Admin findByAdminName(String adminName);

    public Admin findByAdminUserName(String adminUserName);
}

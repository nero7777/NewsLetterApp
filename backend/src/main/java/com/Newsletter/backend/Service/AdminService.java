package com.Newsletter.backend.Service;

import com.Newsletter.backend.Entity.Admin;
import com.Newsletter.backend.Error.AdminNotFoundException;
import com.Newsletter.backend.Error.LoginException;

import java.util.List;

public interface AdminService {
    String logAdminIn(Admin admin) throws AdminNotFoundException, LoginException;

    Admin getAdminByAdminUserName(String userName) throws AdminNotFoundException;

    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmins();
}

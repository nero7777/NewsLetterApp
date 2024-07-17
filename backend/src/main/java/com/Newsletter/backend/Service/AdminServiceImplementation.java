package com.Newsletter.backend.Service;

import com.Newsletter.backend.Entity.Admin;
import com.Newsletter.backend.Error.AdminNotFoundException;
import com.Newsletter.backend.Error.LoginException;
import com.Newsletter.backend.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String logAdminIn(Admin admin) throws AdminNotFoundException,LoginException {

        String message="";

        Admin foundAdmin = adminRepository.findByAdminUserName(admin.getAdminUserName());
        if(!Objects.nonNull(foundAdmin)){
            throw new AdminNotFoundException("Admin Doesn't Exist");
        }

        if(foundAdmin.getAdminUserName().equals(admin.getAdminUserName())){
            if(foundAdmin.getAdminPassword().equals(admin.getAdminPassword())){
                message = "Logged In successfully";
            }else {
            throw new LoginException("Wrong Password!!!");
            }
        }
        return message;
    }

    @Override
    public Admin getAdminByAdminUserName(String name) throws AdminNotFoundException{
        Admin foundAdmin = adminRepository.findByAdminUserName(name);

        if(Objects.nonNull(foundAdmin)){
            return foundAdmin;
        }else{
            throw new AdminNotFoundException("Admin with the provided username doesn't exists !!");
        }
    }



    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}

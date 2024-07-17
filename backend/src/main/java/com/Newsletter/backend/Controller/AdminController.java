package com.Newsletter.backend.Controller;

import com.Newsletter.backend.Entity.Admin;
import com.Newsletter.backend.Error.AdminNotFoundException;
import com.Newsletter.backend.Error.LoginException;
import com.Newsletter.backend.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @GetMapping("/getAll")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/get/{userName}")
    public Admin getAdminByUserName(@PathVariable String userName) throws AdminNotFoundException {
        return adminService.getAdminByAdminUserName(userName);
    }


    @PostMapping("/login")
    public String adminLogin(@RequestBody Admin admin) throws AdminNotFoundException,LoginException{
        return adminService.logAdminIn(admin);
    }

}

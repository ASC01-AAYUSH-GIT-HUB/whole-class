package org.com.controller;

import org.com.service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ats/admin")
public class AdminController {
    private final AdminServiceInterface adminService;
    @Autowired
    public AdminController(AdminServiceInterface adminService){
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestController loginValues){
        return adminService.login(loginValues.getEmail(),loginValues.getPassword());
    }

}

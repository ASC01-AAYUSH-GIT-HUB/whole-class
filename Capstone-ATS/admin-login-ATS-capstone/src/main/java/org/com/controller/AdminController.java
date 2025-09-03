package org.com.controller;

import org.com.dto.LoginRequestDTO;
import org.com.dto.RegisterAdminDTO;
import org.com.dto.ResultDTO;
import org.com.service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/ats/admin")
public class AdminController {
    private final AdminServiceInterface adminService;
    @Autowired
    public AdminController(AdminServiceInterface adminService){
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO loginValues){
        return adminService.login(loginValues.getEmail(),loginValues.getPassword());
    }
    @GetMapping
    public List<ResultDTO> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @PostMapping("/register")
    public String register(@RequestBody RegisterAdminDTO registerAdminDTO){
        return  adminService.register(registerAdminDTO);
    }

}

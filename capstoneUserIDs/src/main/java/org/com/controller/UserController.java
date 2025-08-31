package org.com.controller;

import org.com.userEntity.UserDisplayEntity;
import org.com.userEntity.UserIdEntity;
import org.com.userEntity.UserInputEntity;
import org.com.userService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceInterface userServiceInterface;
    @Autowired
    public UserController(UserServiceInterface userServiceInterface){
        this.userServiceInterface=userServiceInterface;
    }

    @GetMapping("/getById/{userId}")
    UserDisplayEntity getById(@PathVariable String userId){
        return userServiceInterface.getById(userId);
    }

    @GetMapping("/getByName/{userName}")
    List<UserIdEntity> getByName(@PathVariable String userName){
        return userServiceInterface.getByName(userName);
    }

    @PostMapping("/registeruser")
    void adduser(@RequestBody UserInputEntity userInputEntity){
        System.err.println("aksa"+userInputEntity.getUserName()+" "+userInputEntity.getPassword());
        UserIdEntity userIdEntity = new UserIdEntity(userInputEntity.getUserName(),userInputEntity.getPassword());
        userIdEntity.setUserId("_");
        userServiceInterface.addUser(userIdEntity);
    }
}

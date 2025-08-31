package org.com.userService;

import org.com.userEntity.UserDisplayEntity;
import org.com.userEntity.UserIdEntity;
import org.com.userRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplement implements UserServiceInterface{
    private final UserRepo userRepo;
    @Autowired
    public UserServiceImplement(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDisplayEntity getById(String userId) {
        UserIdEntity userIdEntity=userRepo.findByUserId(userId);
        return new UserDisplayEntity(userIdEntity.getUserId(),userIdEntity.getUserName());
    }

    @Override
    public List<UserIdEntity> getByName(String userName) {
        return userRepo.findByUserNameIgnoreCase(userName);
    }

    @Override
    public UserIdEntity addUser(UserIdEntity userIdEntity) {
        UserIdEntity userIdEntity1= userRepo.save(userIdEntity);
        userIdEntity1.generateUserId();
        return userRepo.save(userIdEntity1);
    }

    @Override
    public void update(UserIdEntity userIdEntity) {
        UserIdEntity userIdEntity1=userRepo.findByUserId(userIdEntity.getUserId());
        userIdEntity1.setUserName(userIdEntity.getUserName());
        userIdEntity1.setUserPass(userIdEntity.getUserPass());
        userRepo.save(userIdEntity);
    }


}

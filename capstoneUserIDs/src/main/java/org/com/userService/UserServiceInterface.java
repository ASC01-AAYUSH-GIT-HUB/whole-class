package org.com.userService;

import org.com.userEntity.UserDisplayEntity;
import org.com.userEntity.UserIdEntity;

import java.util.List;

public interface UserServiceInterface {
    public UserDisplayEntity getById(String userId);
    public List<UserIdEntity> getByName(String userName);
    public UserIdEntity addUser(UserIdEntity userIdEntity);
    public void update(UserIdEntity userIdEntity);

}

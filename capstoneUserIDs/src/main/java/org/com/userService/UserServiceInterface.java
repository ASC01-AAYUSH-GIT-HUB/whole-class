package org.com.userService;

import org.com.userEntity.UserIdEntity;

import java.util.List;

public interface UserServiceInterface {
    public UserIdEntity getById(String userId);
    public List<UserIdEntity> getByName(String userName);

}

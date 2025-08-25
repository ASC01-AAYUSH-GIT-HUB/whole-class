package org.com.userRepo;

import org.com.userEntity.UserIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepo extends JpaRepository<UserIdEntity,Long> {
    UserIdEntity findByUserId(String userId);
    List<UserIdEntity> findByUserNameIgnoreCase(String userName);

}

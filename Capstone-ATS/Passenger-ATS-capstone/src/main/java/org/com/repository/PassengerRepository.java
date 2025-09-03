package org.com.repository;

import org.com.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity,String> {
    boolean existsByEmail(String email);// derived query keywords
    boolean existsByPhone(String phone);
}

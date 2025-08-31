package org.com.repository;

import org.com.entity.PlaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<PlaneEntity,String > {
}

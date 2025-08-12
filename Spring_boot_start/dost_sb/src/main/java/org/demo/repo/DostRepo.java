package org.demo.repo;

import org.demo.entity.DostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DostRepo extends JpaRepository<DostEntity,Long> {
}

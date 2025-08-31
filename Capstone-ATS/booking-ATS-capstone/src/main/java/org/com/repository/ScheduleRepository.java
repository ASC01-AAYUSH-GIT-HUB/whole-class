package org.com.repository;

import org.com.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, String> {
}
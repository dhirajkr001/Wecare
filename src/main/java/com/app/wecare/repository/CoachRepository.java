package com.app.wecare.repository;

import com.app.wecare.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends CrudRepository<Coach, String> {
}

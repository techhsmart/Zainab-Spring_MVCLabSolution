package com.college.festival.repo;

import com.college.festival.models.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<user, Long> {
}

package com.klef.jfsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.jfsd.project.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    // You can add custom queries if needed in the future
	
	
}

package com.example.demo.Repositories;
import java.util.*;

import com.example.demo.Models.UserTB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTB, Long> {
	// Find all users by email
	List<UserTB> findByEmail(String email);

	// Find all users by name
	List<UserTB> findByName(String name);

	// Find all users by phone number
	List<UserTB> findByPhoneNumber(String phoneNumber);

	// Find user by email and name
	Optional<UserTB> findByEmailAndName(String email, String name);

	// Get all users ordered by name ascending
	List<UserTB> findAllByOrderByNameAsc();
}

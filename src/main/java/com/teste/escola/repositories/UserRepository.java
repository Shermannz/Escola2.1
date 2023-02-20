package com.teste.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.escola.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}

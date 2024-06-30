package com.boot.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.jpa.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}

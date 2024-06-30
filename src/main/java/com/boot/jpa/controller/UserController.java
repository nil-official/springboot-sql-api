package com.boot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.entities.User;
import com.boot.jpa.exception.ResourceNotFoundException;
import com.boot.jpa.repo.UserRepo;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	// get all users api
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepo.findAll();
	}
	
	// get user by id api
	@GetMapping("/{id}")
	public User getUsersById(@PathVariable (value = "id") long userId) {
		return this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
		
	}
	
	// create user api
	@PostMapping
	public User createUser(@RequestBody User user) {
		System.out.println(user);
		return this.userRepo.save(user);
		
	}
	
	// update user by id api
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User existingUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		return this.userRepo.save(existingUser);
	}
	
	// delete user by id api
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		User existingUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
		this.userRepo.delete(existingUser);
		return ResponseEntity.ok().build();
	}
}

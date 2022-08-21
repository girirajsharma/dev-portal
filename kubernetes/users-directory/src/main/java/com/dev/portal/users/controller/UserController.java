package com.dev.portal.users.controller;

import com.dev.portal.users.User;
import com.dev.portal.users.error.UserNotFoundException;
import com.dev.portal.users.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

  @Autowired private UserRepository userRepository;

  @GetMapping("/users/{userId}")
  public ResponseEntity<User> getUser(@PathVariable String userId) {
    log.info("Fetching user {}", userId);
    var userOptional = userRepository.getUser(userId);
    User user = userOptional.orElseThrow(UserNotFoundException::new);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping("/users")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    log.info("Saving user");
    var savedUser = userRepository.save(user);
    return new ResponseEntity<>(savedUser, HttpStatus.OK);
  }
}

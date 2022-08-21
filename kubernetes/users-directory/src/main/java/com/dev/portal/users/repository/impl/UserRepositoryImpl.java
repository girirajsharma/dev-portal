package com.dev.portal.users.repository.impl;

import com.dev.portal.users.User;
import com.dev.portal.users.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepository {

  private Map<String, User> storage = new HashMap<>();

  @Override
  public Optional<User> getUser(String userId) {
    log.info("Finding details of user, id {}", userId);
    return Optional.ofNullable(storage.get(userId));
  }

  @Override
  public User save(User user) {
    log.info("Saving user {}", user);
    var uuid = UUID.randomUUID().toString();
    user.setId(uuid);
    storage.put(uuid, user);
    return user;
  }
}

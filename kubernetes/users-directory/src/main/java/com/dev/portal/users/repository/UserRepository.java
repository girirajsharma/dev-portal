package com.dev.portal.users.repository;

import com.dev.portal.users.User;
import java.util.Optional;

public interface UserRepository {

  /**
   * Get User by ID
   *
   * @param userId User Id
   * @return user
   */
  Optional<User> getUser(String userId);

  /**
   * Save user
   *
   * @param user user to be saved
   * @return Saved user
   */
  User save(User user);
}

package com.cooking.finder.repository.interfaces;

import com.cooking.finder.repository.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Igor on 15.10.2016.
 */
public interface UserRepository extends GenericRepository<User> {

    User findByIdentifier(User user);
}

package com.cooking.finder.repository.impl;

import com.cooking.finder.configuration.SpringRepositoryTestConfiguration;
import com.cooking.finder.repository.interfaces.UserRepository;
import com.cooking.finder.repository.model.User;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Igor on 15.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRepositoryTestConfiguration.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @DirtiesContext
    public void shouldFindAll() {
        User user = new User();
        user.setUsername("test12345");
        user.setPassword("somepassword");
        user.setEmail("igorsudijovski@gmail.com");
        user.setFirstName("igor");
        user.setLastName("sudijovski");
        user.setAccessToken("someToken");
        user.setAccessTokenCreation(DateTime.now());
        userRepository.insert(user);

        List<User> users = userRepository.findAll();

        System.out.println("test");


    }
}

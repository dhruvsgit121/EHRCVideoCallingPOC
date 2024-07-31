package com.EHRC.VideoCalling.Service;


import com.EHRC.VideoCalling.Models.User;
import com.EHRC.VideoCalling.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) throws SQLException {
        return userRepository.save(user);
    }

}

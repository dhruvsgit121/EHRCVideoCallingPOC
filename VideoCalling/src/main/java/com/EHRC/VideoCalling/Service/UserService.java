package com.EHRC.VideoCalling.Service;


import com.EHRC.VideoCalling.Models.User;
import com.EHRC.VideoCalling.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

//import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) throws SQLException {
        return userRepository.save(user);
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> getDoctorDetails(int id) {
        return userRepository.findByUserIDandRole(id, "mhp");
    }

    public Optional<User> getPatientDetails(int id) {
        return userRepository.findByUserIDandRole(id, "patient");
    }
}

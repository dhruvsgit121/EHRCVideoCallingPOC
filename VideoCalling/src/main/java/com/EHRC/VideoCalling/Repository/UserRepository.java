package com.EHRC.VideoCalling.Repository;

import com.EHRC.VideoCalling.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    // Custom query with multiple parameters
    @Query("SELECT u FROM User u WHERE u.id = :id AND u.role = :role")
    Optional<User> findByUserIDandRole(@Param("id") Integer id, @Param("role") String role);


    // Custom query using JPQL
//    @Query("SELECT u FROM User u WHERE u.name = :name")
//    List<User> findByName(@Param("name") String name);
//
//    // Custom query using native SQL
//    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
//    User findByEmail(@Param("email") String email);
//
//    // Custom query with multiple parameters
//    @Query("SELECT u FROM User u WHERE u.name = :name AND u.email = :email")
//    List<User> findByNameAndEmail(@Param("name") String name, @Param("email") String email);
//
//    // Custom query with a projection
//    @Query("SELECT u.name FROM User u WHERE u.id = :id")
//    String findNameById(@Param("id") Integer id);







}

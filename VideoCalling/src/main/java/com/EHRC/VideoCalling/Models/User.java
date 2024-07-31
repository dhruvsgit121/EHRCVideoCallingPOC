package com.EHRC.VideoCalling.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false, unique = true)
    private String name;

    @Column(name = "userrole", nullable = false)
    private String role;

    @Column(name = "contactnumber", nullable = false, unique = true)
    private String contactNumber;

}

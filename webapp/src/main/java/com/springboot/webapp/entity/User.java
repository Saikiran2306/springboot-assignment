package com.springboot.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private  String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="gender")
    private String gender;

}

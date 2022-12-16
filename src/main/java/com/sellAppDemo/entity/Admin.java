package com.sellAppDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//
//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String  email;

    private String phoneno;

    private String address;

    private String password;
}

package com.sellAppDemo.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;

    private String name;

    private  String email;
    private String address;

    private String phoneno;

    private String password;
}

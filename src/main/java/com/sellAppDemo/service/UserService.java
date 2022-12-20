package com.sellAppDemo.service;

import com.sellAppDemo.dto.UserDto;
import com.sellAppDemo.entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(UserDto userDto);

    public List<UserDto> fetchUserList();

    public User getUser(Integer id);
}

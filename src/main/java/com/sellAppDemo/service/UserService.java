package com.sellAppDemo.service;

import com.sellAppDemo.dto.UserDto;
import com.sellAppDemo.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(UserDto userDto);

    public List<UserDto> fetchUserList();

    public Optional<User> getUser(Integer id);

//    public ResponseEntity<?> getById(Integer id);
}

package com.sellAppDemo.controller;

import com.sellAppDemo.dto.UserDto;
import com.sellAppDemo.entity.User;
import com.sellAppDemo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    public UserService userService;

//    @PostMapping("/save")
//    ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
//        userService.saveUser(userDto);
//        return new ResponseEntity<>("saved successfully", HttpStatus.OK);
//    }

    @PostMapping("/save")
    public User saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }
//    @GetMapping("/getUser").
//    public List<UserDto> fetchJUserList(){
//        return userService.fetchUserList();
//    }
}

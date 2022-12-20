package com.sellAppDemo.controller;

import com.sellAppDemo.dto.UserDto;
import com.sellAppDemo.entity.User;
import com.sellAppDemo.service.UserService;
import com.sellAppDemo.serviceImpl.UserExcelExporter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserExcelExporter ex;

    @Autowired
    public UserService userService;

    @PostMapping("/save")
    ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return new ResponseEntity<>("saved successfully", HttpStatus.OK);
    }

//    @PostMapping("/save")
//    public User saveUser(@RequestBody UserDto userDto) {
//        return userService.saveUser(userDto);
//    }
    @GetMapping("/getUser")
    public List<UserDto> fetchJUserList(){
        return userService.fetchUserList();
    }

    @GetMapping("/download")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<UserDto> listUsers = userService.fetchUserList();

        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);

        excelExporter.export(response);
    }
}

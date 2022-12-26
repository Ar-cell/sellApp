package com.sellAppDemo.serviceImpl;

import com.sellAppDemo.dto.UserDto;
import com.sellAppDemo.entity.User;
import com.sellAppDemo.repository.UserRepository;
import com.sellAppDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneno(userDto.getPhoneno());
        UUID uuid = UUID.randomUUID();
        user.setPassword(uuid.toString());
        user.setAddress(userDto.getAddress());
        userRepository.save(user);
        return null;
    }

    @Override
    public List<UserDto> fetchUserList() {
        List<UserDto> dtoList = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for(User user:list){
            UserDto dt = new UserDto();
            dt.setId(user.getId());
            dt.setAddress(user.getAddress());
            dt.setName(user.getName());
            dt.setEmail(user.getEmail());
            UUID uuid=UUID.randomUUID();  // rendom password generation
            dt.setPassword(uuid.toString());
            dt.setPhoneno(user.getPhoneno());
            dtoList.add(dt);
        }
        return dtoList;
    }

    @Override
    public Optional<User> getUser(Integer id) {
    Optional<User> usreOptional = userRepository.findById(id);
    if(!usreOptional.isPresent()){
        System.out.println("user not found for this id: " + id);
    }
        return userRepository.findById(id);
    }

//    @Override
//    public ResponseEntity<?> getById(Integer id) {
//        Optional<User> userOptional = userRepository.findById(id);
//        if(!userOptional.isPresent()){
//            return new ResponseEntity<>("not found for this id :", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>
//    }

    public UserDto userById(Integer id){
        Optional<User> userOp = userRepository.findById(id);
        if(userOp.isPresent()){
            User user = userOp.get();
            UserDto dt = new UserDto();
            dt.setAddress(user.getAddress());
            dt.setEmail(user.getEmail());
            dt.setPhoneno(user.getPhoneno());
            dt.setName(user.getName());
            dt.setId(user.getId());
            return dt;
        }

        return null;
    }
}

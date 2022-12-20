package com.sellAppDemo.serviceImpl;

import com.sellAppDemo.dto.UserDto;
import com.sellAppDemo.entity.User;
import com.sellAppDemo.repository.UserRepository;
import com.sellAppDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        user.setPassword(userDto.getPassword());
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
            dt.setPassword(user.getPassword());
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
    public User getUser(Integer id) {
        return null;
    }
}

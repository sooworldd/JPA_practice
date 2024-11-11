package com.react.prac.service;

import com.react.prac.DTO.UsersDTO;
import com.react.prac.Entity.Users;
import com.react.prac.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    public void registerUser(UsersDTO userDTO) {
        Users user = new Users();
        user.setUserId(userDTO.getUserId());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            user.setBirthDate(LocalDate.parse(userDTO.getBirthDate(), formatter));  // String을 LocalDate로 변환
        } catch (Exception e) {
            throw new RuntimeException("Invalid birth date format", e);
        }
        user.setAddress(userDTO.getAddress());
        user.setPhone(userDTO.getPhone());
        usersRepository.save(user);
    }

    public Users getUserByUserId(String userId) {
        Optional<Users> userOptional = usersRepository.findByUserId(userId);
        return userOptional.orElseThrow(() -> new RuntimeException("User not found"));
    }
}

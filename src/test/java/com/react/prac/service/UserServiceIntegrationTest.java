package com.react.prac.service;

import com.react.prac.DTO.UsersDTO;
import com.react.prac.Entity.Users;
import com.react.prac.PracApplication;
import com.react.prac.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = PracApplication.class)
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void testRegisterUser() {
        // given
        UsersDTO userDTO = new UsersDTO();
        userDTO.setUserId("user2");
        userDTO.setPassword("password123");
        userDTO.setUsername("Jane Doe");
        userDTO.setEmail("jane@example.com");
        userDTO.setBirthDate("1990-01-01");
        userDTO.setAddress("123 Main St");
        userDTO.setPhone("123-456-7890");

        // when
        usersService.registerUser(userDTO);

        // then
        Users user = usersRepository.findByUserId("user2").orElseThrow(() -> new RuntimeException("User not found"));
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("Jane Doe");
        assertThat(user.getBirthDate()).isEqualTo(LocalDate.parse("1990-01-01"));
        assertThat(user.getAddress()).isEqualTo("123 Main St");
        assertThat(user.getPhone()).isEqualTo("123-456-7890");
    }
}
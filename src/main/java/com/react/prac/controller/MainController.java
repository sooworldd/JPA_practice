package com.react.prac.controller;

import com.react.prac.DTO.UsersDTO;
import com.react.prac.Entity.Users;
import com.react.prac.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    UsersService usersService;

    @PostMapping("/join")
    public ResponseEntity<String> insertUser(@Valid @RequestBody UsersDTO usersDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }

        try {
            usersService.insertUser(usersDTO);
            return ResponseEntity.ok("Join_Success");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("회원가입 실패: " + e.getMessage());
        }
    }
}

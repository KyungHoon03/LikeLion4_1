package com.example.likelion4_1.controller;

import com.example.likelion4_1.dto.UserDto;
import com.example.likelion4_1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor // final 생성자 롱북
public class UserController {
    private final UserService userService;

    @PostMapping("/logon")
    public ResponseEntity<String> getLogon(@RequestBody UserDto userDto) {

        return userService.logon(userDto);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.readAll();
    }


}

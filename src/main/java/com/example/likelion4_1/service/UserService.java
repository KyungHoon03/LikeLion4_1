package com.example.likelion4_1.service;

import com.example.likelion4_1.dto.UserDto;
import com.example.likelion4_1.entity.UserEntity;
import com.example.likelion4_1.repository.BoardRepository;
import com.example.likelion4_1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor//final 생성자 자동 생성
@Slf4j // 로그 바로 넣어주려고 사용, log.info 등
public class UserService {
    private final UserRepository userRepository;
    //*******************************
    public ResponseEntity<String> logon(UserDto userDto) {

        UserEntity userEntity = new UserEntity(userDto.getUserId(), userDto.getUserName(), userDto.getPassword(), userDto.getEmail());
        userEntity.update(userDto.getId());
        userRepository.save(userEntity);
        return ResponseEntity.ok("User logged in");
    }

    //*******************************
    public List<UserDto> readAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (UserEntity entity : userEntities) {
            UserDto userDto = new UserDto(entity.getId(), entity.getUserId(), entity.getUserName(), entity.getPassward(), entity.getEmail());
            userDtos.add(userDto);
        }
        return userDtos;
    }


}

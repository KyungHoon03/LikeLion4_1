package com.example.likelion4_1.service;

import com.example.likelion4_1.dto.BoardDto;
import com.example.likelion4_1.entity.BoardEntity;
import com.example.likelion4_1.entity.UserEntity;
import com.example.likelion4_1.repository.BoardRepository;
import com.example.likelion4_1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor//final 생성자 자동 생성
@Slf4j // 로그 바로 넣어주려고 사용, log.info 등

public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    //*************************************************************
    public void save(BoardDto boardDto) {// 생성
        UserEntity user = userRepository.findById(boardDto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        BoardEntity boardEntity = new BoardEntity(user, boardDto.getTitle(), boardDto.getContent());
        boardRepository.save(boardEntity);
    }
    //*************************************************************
    public List<BoardDto> readAll() {//전체 조회
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDto = new ArrayList<>();

        for (BoardEntity entity : boardEntities) {
            UserEntity user = entity.getUserEntity();
            BoardDto dto = new BoardDto(entity.getId(), entity.getTitle(), entity.getContent(), user.getId());
            boardDto.add(dto);
        }

        return boardDto;
    }
    //*************************************************************
    public List<BoardDto> readById(int userId) {// id 조회
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        List<BoardEntity> boardEntity = boardRepository.findByUserEntity_Id(userId);
        return boardEntity.stream()
                .map(board -> new BoardDto(
                        board.getId(),
                        board.getTitle(),
                        board.getContent(),
                        board.getUserEntity().getId()
                ))
                .collect(Collectors.toList());

    }
    //*************************************************************
    public void deleteById(int id) {
        boardRepository.deleteById(id);
    }
    //*************************************************************
    public void updateById(int id, BoardDto boardDto) {
        BoardEntity boardEntity = boardRepository.findById(id).orElse(null);
        /*
        boardEntity.setTitle(boardDto.getTitle());
        boardEntity.setContent(boardDto.getContent());
        */
        boardEntity.update(boardDto.getTitle(), boardDto.getContent());
        boardRepository.save(boardEntity);

    }

}


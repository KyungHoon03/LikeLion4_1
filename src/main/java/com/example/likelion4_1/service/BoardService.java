package com.example.likelion4_1.service;

import com.example.likelion4_1.dto.BoardDto;
import com.example.likelion4_1.entity.BoardEntity;
import com.example.likelion4_1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor//final 생성자 자동 생성
@Slf4j // 로그 바로 넣어주려고 사용, log.info 등

public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDto boardDto) {
        BoardEntity boardEntity = new BoardEntity(boardDto.getTitle(), boardDto.getContent());
        boardRepository.save(boardEntity);
    }

    public List<BoardDto> readAll() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDto = new ArrayList<>();

        for (BoardEntity entity : boardEntities) {
            BoardDto dto = new BoardDto(entity.getId(), entity.getTitle(), entity.getContent());
            boardDto.add(dto);
        }

        return boardDto;
    }





}


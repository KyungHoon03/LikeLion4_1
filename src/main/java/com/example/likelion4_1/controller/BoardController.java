package com.example.likelion4_1.controller;

import com.example.likelion4_1.dto.BoardDto;
import com.example.likelion4_1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor // final 생성자 롱북
public class BoardController {
    private final BoardService boardService;


    @PostMapping("/create")
    public void saveBoard(@RequestBody BoardDto boardDto) {
        boardService.save(boardDto);

    }

    @GetMapping("/read")
    public List<BoardDto> readBoard() { //@RequestParam int id

        return boardService.readAll();

    }



}

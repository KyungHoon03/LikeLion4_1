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

    @GetMapping("/read/{userId}")
    public List<BoardDto> readBoardId(@PathVariable int userId) {
        return boardService.readById(userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBoard(@PathVariable int id) {
        boardService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
        boardService.updateById(id, boardDto);
    }


}

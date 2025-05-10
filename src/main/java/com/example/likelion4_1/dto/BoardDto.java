package com.example.likelion4_1.dto;


import com.example.likelion4_1.entity.BoardEntity;
import com.example.likelion4_1.entity.UserEntity;

public class BoardDto {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


    public Integer getUserId() {
        return userId;
    }

    public BoardDto(Integer id, String title, String content, Integer userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }


}

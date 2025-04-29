package com.example.likelion4_1.dto;


public class BoardDto {
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public BoardDto(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}

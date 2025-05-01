package com.example.likelion4_1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "board")

public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "content", length = 500)
    private String content;

    public BoardEntity( String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void update( String tittle, String content){
        this.title = tittle;
        this.content = content;
    }

    public BoardEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


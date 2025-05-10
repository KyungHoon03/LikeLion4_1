package com.example.likelion4_1.entity;
import com.example.likelion4_1.entity.UserEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@NoArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //**************************
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
    //*******************



    //*****************

    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "content", length = 500)
    private String content;

    public BoardEntity(UserEntity userEntity, String title, String content) {
        this.userEntity = userEntity;
        this.title = title;
        this.content = content;
    }
    public void update( String tittle, String content){
        this.title = tittle;
        this.content = content;
    }

    public UserEntity getUserEntity() {
        return userEntity;
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

    //*************************



}


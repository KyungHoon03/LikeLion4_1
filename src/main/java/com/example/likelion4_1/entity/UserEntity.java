package com.example.likelion4_1.entity;

import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
@Table(name = "user")// 테이블 이름 구분 힘들 때 어노테이션
//@NoArgsConstructor // 기본 생성자 롬북
//@AllArgsConstructor // this 하는 생성자 롬북
//@Getter
//@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //여기서부터 내 DB에 맞는 코드

    @Column(name = "userId")
    private String userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "passward")
    private String passward;

    public UserEntity(int id, String userId, String userName, String passward) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.passward = passward;
    }

    public UserEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }
}

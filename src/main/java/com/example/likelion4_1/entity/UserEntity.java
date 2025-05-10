package com.example.likelion4_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.likelion4_1.entity.BoardEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")// 테이블 이름 구분 힘들 때 어노테이션
@NoArgsConstructor // 기본 생성자 롬북
@AllArgsConstructor // this 하는 생성자 롬북
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;

    //**************************
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardEntity> boards = new ArrayList<>();
    //**************************
    //여기서부터 내 DB에 맞는 코드

    @Column(name = "userName", length = 45)
    private String userName;

    @Column(name = "password", length = 256)
    private String password;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    public UserEntity(String userName, String password, String email) {

        this.userName = userName;
        this.password = password;
        this.email = email;
    }

}

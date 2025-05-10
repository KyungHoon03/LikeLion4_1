package com.example.likelion4_1.repository;


import com.example.likelion4_1.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    List<BoardEntity> findByUserEntity_Id(Integer userId);

}


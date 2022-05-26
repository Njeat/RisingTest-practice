package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int userIdx;
    private String phoneNum;
    private String userName;
    private String profileImgUrl;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.example.demo.src.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostProductReq {
    private List<String> productImgUrl;
    private String title;
    private String content;
    private int price;
    private String category;
}

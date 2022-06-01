package com.example.demo.src.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int productIdx;
    private int userIdx;
//    private List<ProductImg> productImgs;
    private String title;
    private String content;
    private int price;
//    private Category category;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

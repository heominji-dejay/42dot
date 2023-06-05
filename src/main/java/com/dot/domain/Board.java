package com.dot.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class Board {
    private Integer boardId;
    private Integer menuId; // 추가
    private String title;
    private String content;
    private String author;
    private Date createdDate;
    private Date updatedDate;

    // getters and setters
}

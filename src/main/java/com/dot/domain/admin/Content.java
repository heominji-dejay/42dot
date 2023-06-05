package com.dot.domain.admin;

import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Content {
    private Integer contentId;
    private Integer menuId;
    private String contentName;
    private String contentType;
    private String contentText;
    private String contentFile;
    private boolean displayStatus;
    private String remarks;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

}


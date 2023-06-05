package com.dot.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Menu {
    private Integer menuId;
    private Integer parentMenuId;
    private Integer menuDepth;
    private String menuNameEn;
    private String menuNameKr;
    private String menuType;
    private String displayStatus;
    private Boolean headerDisplay;
    private Integer headerDisplayOrder;
    private Boolean footerDisplay;
    private Integer footerDisplayOrder;
    private String menuUrl;
    private String remarks;
    private Date createdDate;
    private Date modifiedDate;

    // getters and setters
}


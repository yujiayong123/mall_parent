package com.mszlu.shop.model.buyer.pojo;

import lombok.Data;

@Data
public class PageTemplate{

    private Long id;

    private String name;

    private Integer clientType;

    private Integer pageType;

    private Integer openStatus;

    private Integer status;

    private Long createTime;

    private Long updateTime;
}
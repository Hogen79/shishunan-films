package com.shishunan.filmsservice.entity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class FilmsQuery {

    private String director; //导演

    private String protagonist; //主演

    private Integer tid; //影片分类id
}

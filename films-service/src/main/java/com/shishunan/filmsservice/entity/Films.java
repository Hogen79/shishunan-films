package com.shishunan.filmsservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 影视表字段
 */
@Entity
@Table(name = "films")
@Data
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //影视id
    @Column(name = "name")
    private String name; //影视名称
    @Column(name = "director")
    private String director; //导演
    @Column(name = "protagonist")
    private String protagonist; //主演
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date createTime; //上演日期
    @Column(name = "tid")
    private Integer tid; //影片分类id
    @Column(name = "img")
    private String img; //图片
    @Column(name = "orders")
    private Integer orders; //置顶排序

    //忽略UserEntity的orderList属性
    @JsonIgnoreProperties("typeList")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "tid",referencedColumnName = "id",insertable = false,updatable = false)
    private Types types; //影片类别
}

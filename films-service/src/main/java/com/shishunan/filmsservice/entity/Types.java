package com.shishunan.filmsservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 影视分类表
 */
@Entity
@Table(name = "types")
@Data
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //分类id

    @Column(name = "name")
    private String name; //分类名称

    @Column(name = "pid")
    private Integer pid; //父分类id

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(
            name = "pid",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private List<Types> typeList;
}

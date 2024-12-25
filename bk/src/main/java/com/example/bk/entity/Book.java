package com.example.bk.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author: Jamie Hong
 * @Description:
 * @create: 2024/12/25 18:06
 */
@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "category")
    private String category;
}

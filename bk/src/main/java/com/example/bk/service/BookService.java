package com.example.bk.service;

import com.example.bk.entity.Book;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Jamie Hong
 * @Description:
 * @create: 2024/12/25 18:12
 */
public interface BookService {

    /**
     * find all the books
     * @return
     */
    List<Book> findAll();

    void addShoppingCart(Integer id);

    BigDecimal shoppingCartCheckout();
}

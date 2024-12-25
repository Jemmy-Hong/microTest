package com.example.bk.service.impl;

import com.example.bk.cache.BookCache;
import com.example.bk.entity.Book;
import com.example.bk.repository.BookDao;
import com.example.bk.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Jamie Hong
 * @Description:
 * @create: 2024/12/25 18:14
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public void addShoppingCart(Integer id) {
        Book book = bookDao.findById(id).get();
        BookCache.shoppingCard.add(book);
    }

    @Override
    public BigDecimal shoppingCartCheckout() {
        List<Book> bookList = BookCache.shoppingCard;
        BigDecimal total = new BigDecimal("0.00");
        for (Book book : bookList) {
            total = total.add(book.getPrice());
        }
        return total;
    }
}

package com.example.bk;

import com.example.bk.cache.BookCache;
import com.example.bk.entity.Book;
import com.example.bk.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class BkApplicationTests {


    @Resource
    private BookService bookService;

    @Test
    void testAllMethod() {
        List<Book> books = bookService.findAll();
        Assert.isTrue(books.size() > 0);
    }

    @Test
    void testAddCard() {
        bookService.addShoppingCart(1);
        List<Book> bookList = BookCache.shoppingCard;
        Assert.isTrue(bookList.size() > 0);
    }

    @Test
    void testCheckOut() {
        bookService.addShoppingCart(2);
        BigDecimal bigDecimal = bookService.shoppingCartCheckout();
        Assert.isTrue(bigDecimal.abs().compareTo(new BigDecimal("0.000")) > 0);
    }

}

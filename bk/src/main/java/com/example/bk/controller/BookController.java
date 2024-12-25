package com.example.bk.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.bk.cache.BookCache;
import com.example.bk.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: Jamie Hong
 * @Description:
 * @create: 2024/12/25 18:16
 */
@Api(value = "图书管理", tags = "图书管理相关接口")
@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @ApiOperation(value = "获取图书信息")
    @GetMapping("/book/list")
    @ResponseBody
    public ResponseEntity<?> getAllBooks() {
        return  ResponseEntity.ok().body(bookService.findAll());
    }

    @ApiOperation(value = "添加一个图书到购书单", notes = "选择一个图书的ID，把图书信息添加到购书单")
    @ApiImplicitParam(name = "Id", value = "一个图书的Id", required = true, dataType = "Integer")
    @GetMapping("/shopping/card/{id}")
    @ResponseBody
    public ResponseEntity<?> addToShoppingCart(@PathVariable("id") Integer id) {
        bookService.addShoppingCart(id);
        return ResponseEntity.ok().body(BookCache.shoppingCard);
    }

    @ApiOperation(value = "获取当前购书单的总价格")
    @GetMapping("/shopping/card/checkout")
    @ResponseBody
    public ResponseEntity<?> shoppingCartCheckout() {
         BigDecimal totalPrice = bookService.shoppingCartCheckout();
        return ResponseEntity.ok().body(totalPrice);
    }

}

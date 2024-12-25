package com.example.bk.repository;

import com.example.bk.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Jamie Hong
 * @Description:
 * @create: 2024/12/25 18:11
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

}

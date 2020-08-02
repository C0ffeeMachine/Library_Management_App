package com.example.MyApp1.DataAccessLayer;

import com.example.MyApp1.DataAccessLayer.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}

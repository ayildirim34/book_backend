package com.ahmyil.buchshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmyil.buchshop.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByTitleContaining(String title);
}

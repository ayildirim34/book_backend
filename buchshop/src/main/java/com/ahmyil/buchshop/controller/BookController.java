package com.ahmyil.buchshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmyil.buchshop.model.Book;
import com.ahmyil.buchshop.model.Users;
import com.ahmyil.buchshop.service.BookService;

@Controller
@RequestMapping("/api/book")
public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.createBook(book), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity(bookService.getAllBooks(), HttpStatus.OK);
	}
	

}

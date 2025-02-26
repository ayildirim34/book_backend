package com.ahmyil.buchshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmyil.buchshop.model.Book;
import com.ahmyil.buchshop.repository.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getBookByTitleContain(String title){
		return bookRepository.findByTitleContaining(title);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(Long id){
		return bookRepository.findById(id);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);;
	}
}

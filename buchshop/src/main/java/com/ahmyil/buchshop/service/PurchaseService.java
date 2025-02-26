package com.ahmyil.buchshop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmyil.buchshop.exception.BookNotFoundException;
import com.ahmyil.buchshop.exception.EnoughStockNotException;
import com.ahmyil.buchshop.exception.UserNotFoundNotException;
import com.ahmyil.buchshop.model.Book;
import com.ahmyil.buchshop.model.Purchase;
import com.ahmyil.buchshop.model.Users;
import com.ahmyil.buchshop.repository.BookRepository;
import com.ahmyil.buchshop.repository.PurchaseRepository;

@Service
public class PurchaseService {

	private PurchaseRepository purchaseRepository;
	private UserService userService;
	private BookService bookService;
	private BookRepository bookRepository;

	public PurchaseService(PurchaseRepository purchaseRepository, UserService userService, BookService bookService,
			BookRepository bookRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
		this.userService = userService;
		this.bookService = bookService;
		this.bookRepository = bookRepository;
	}

	public Purchase createRepository(Long userId, Long bookId, int quantity) {
	
		Users user = userService.getUserById(userId).orElseThrow(()-> new UserNotFoundNotException("Username dont found"));
		Book book = bookService.getBookById(bookId).orElseThrow(()-> new BookNotFoundException("Book not found"));
		if(book.getStock()<quantity) {
	new EnoughStockNotException("Not enough stock");
		}
		
		book.setStock(book.getStock()-quantity);
		bookRepository.save(book);
		
		Purchase purchase = new Purchase();
		purchase.setBook(book);
		purchase.setUser(user);
		purchase.setPurchaseDateTime(LocalDateTime.now());
		purchase.setQuantity(quantity);
		
		return purchaseRepository.save(purchase);
	}
}

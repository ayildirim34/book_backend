package com.ahmyil.buchshop.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	private int quantity;
	private LocalDateTime purchaseDateTime;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}

	public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}

package com.ahmyil.buchshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmyil.buchshop.model.Purchase;
import com.ahmyil.buchshop.service.PurchaseService;

@Controller
@RequestMapping("/api/purchases")
public class PurchaseController {

	private PurchaseService purchaseService;

	public PurchaseController(PurchaseService purchaseService) {
		super();
		this.purchaseService = purchaseService;
	}
	
	@PostMapping
	public ResponseEntity<Purchase> createPurchase( @RequestParam("userId") Long userId,
		    @RequestParam("bookId") Long bookId,
		    @RequestParam("quantity") int quantity) {
		return new ResponseEntity<>(purchaseService.createRepository(userId, bookId, quantity), 
				HttpStatus.CREATED);
	}
}

package com.ahmyil.buchshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmyil.buchshop.model.Purchase;
import com.ahmyil.buchshop.model.Users;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
List<Purchase> findByUser(Users user);
}
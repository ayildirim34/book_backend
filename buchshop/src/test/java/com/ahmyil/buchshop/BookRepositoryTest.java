package com.ahmyil.buchshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ahmyil.buchshop.model.Book;
import com.ahmyil.buchshop.repository.BookRepository;

@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookRepositoryTest {
	@Autowired
	private BookRepository bookRepository;

	

	@Test
	public void testFindByTitleContaining() {
		Book book1 = new Book("book1", "author1", 29.99);
		Book book2 = new Book("book2", "author2", 19.99);
		
		bookRepository.save(book1);
		bookRepository.save(book2);
		
		List<Book> books = bookRepository.findByTitleContaining("book");
		
        Assertions.assertThat(books.get(0).getTitle()).isEqualTo("book1");



		
	}
	
	
	
}

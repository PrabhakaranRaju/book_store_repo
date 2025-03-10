package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BookStoreServiceTest {

    @Test
    public void testSingleBookPrice() {

        Map<String, Integer> books = new HashMap<>();
        books.put("Clean Code", 1);
        BookstoreService service = new BookstoreService();
        double price = service.calculatePrice(books);
        assertEquals(50.0, price, 0.01);  // Using delta for floating point comparison
    }

    @Test
    public void testTwoDifferentBooks() {
        Map<String, Integer> books = new HashMap<>();
        books.put("Clean Code", 1);
        books.put("The Clean Coder", 1);
        BookstoreService service = new BookstoreService();
        double price = service.calculatePrice(books);
        assertEquals(95.0, price, 0.01);
    }
}

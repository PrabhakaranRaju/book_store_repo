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
        assertEquals(50.0, price, 0.01);
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

    @Test
    public void testTwoDifferentBooksWithDifferentCount() {
        Map<String, Integer> books = new HashMap<>();
        books.put("Clean Code", 1);
        books.put("The Clean Coder", 2);
        BookstoreService service = new BookstoreService();
        double price = service.calculatePrice(books);
        assertEquals(145.0, price, 0.01);
    }

    @Test
    public void testMultipleBooksWithDifferentCount() {
        Map<String, Integer> books = new HashMap<>();
        books.put("Clean Code", 2);
        books.put("The Clean Coder", 2);
        books.put("Clean Architecture", 2);
        books.put("Test Driven Development by Example", 1);
        books.put("Working Effectively With Legacy Code", 1);
        BookstoreService service = new BookstoreService();
        double price = service.calculatePrice(books);
        assertEquals(320.0, price, 0.01);
    }

    @Test
    public void testIfBooksAreEmpty() {
        Map<String, Integer> books = new HashMap<>();
        BookstoreService service = new BookstoreService();
        double price = service.calculatePrice(books);
        assertEquals(0.0, price, 0.01);
    }


}

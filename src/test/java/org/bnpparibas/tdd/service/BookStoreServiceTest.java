package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookStoreServiceTest {

    @Test
    public void testSingleBookPrice() {
        BookstoreService service = new BookstoreService();
        List<Book> books = Arrays.asList(new Book("Clean Code"));
        assertEquals(50.0, service.calculatePrice(books),0.0001);
    }
}

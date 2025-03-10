package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;

import java.util.List;

public class BookstoreService {

    public int calculatePrice(List<Book> books) {
        if (books.size() == 1) {
            return 50;
        }
        return 0;
    }
}

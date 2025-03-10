package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;

import java.util.List;

public class BookstoreService {

    private static final double BOOK_PRICE = 50.0;

    public double calculatePrice(List<Book> books) {
        int uniqueBooks = (int) books.stream().map(Book::getBookTitle).distinct().count();
        double discount = getDiscount(uniqueBooks);
        return books.size() * BOOK_PRICE * (1 - discount);
    }

    private double getDiscount(int uniqueBooks) {
        switch (uniqueBooks) {
            case 2:
                return 5 / 100.0;
            case 3:
                return 10 / 100.0;
            case 4:
                return 20 / 100.0;
            case 5:
                return 25 / 100.0;
            default:
                return 0.0;
        }
    }

}

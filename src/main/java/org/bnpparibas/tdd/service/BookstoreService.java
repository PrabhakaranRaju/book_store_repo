package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookstoreService {

    private static final double BOOK_PRICE = 50;
    private static final double[] DISCOUNTS = {0.0, 0.0, 0.05, 0.10, 0.20, 0.25};


    public double calculatePrice(Map<String, Integer> books) {
        List<Integer> bookCounts = new ArrayList<>(books.values());
        double totalPrice = 0.0;
        int distinctBooks = 0;
        for (int count : bookCounts) {
            distinctBooks++;
        }
        totalPrice += distinctBooks * BOOK_PRICE * (1 - DISCOUNTS[distinctBooks]);
        return totalPrice;
    }

}

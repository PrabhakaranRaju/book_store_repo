package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BookstoreService {

    private static final double BOOK_PRICE = 50;
    private static final double[] DISCOUNTS = {0.0, 0.0, 0.05, 0.10, 0.20, 0.25};

    private double findMinPrice(List<Integer> bookCounts) {
        if (bookCounts.isEmpty()) {
            return 0.0;
        }
        double minPrice = Double.MAX_VALUE;
        for (int i = 1; i < bookCounts.size(); i++) {
            List<Integer> remainingBooks = new ArrayList<>(bookCounts);
            for (int j = 0; j < i; j++) {
                bookCounts.set(j, remainingBooks.get(j) - 1);
            }
            double price = i * BOOK_PRICE * (1 - DISCOUNTS[i]);
            minPrice = Math.min(minPrice, price);
        }
        return minPrice;
    }

    public double calculatePrice(Map<String, Integer> books) {
        List<Integer> bookCounts = new ArrayList<>(books.values());
        Collections.sort(bookCounts, Collections.reverseOrder());
        return findMinPrice(bookCounts);
//        double totalPrice = 0.0;
//        while (true) {  //to form groups
//            int distinctBooks = 0;
//            for (int i = 0; i < bookCounts.size(); i++) {
//                if (bookCounts.get(i) > 0) {
//                    bookCounts.set(i, bookCounts.get(i) - 1);
//                    distinctBooks++;
//                }
//            }
//            if (distinctBooks == 0) {
//                break;
//            }
//            totalPrice += distinctBooks * BOOK_PRICE * (1 - DISCOUNTS[distinctBooks]);
//        }
//        return totalPrice;
    }

}

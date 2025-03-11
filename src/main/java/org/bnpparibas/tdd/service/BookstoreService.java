package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;

import java.util.*;

public class BookstoreService {

    private static final double BOOK_PRICE = 50;
    private static final double[] DISCOUNTS = {0.0, 0.0, 0.05, 0.10, 0.20, 0.25};
    private static final Map<String, Double> memo = new HashMap<>();
    private int bookSize;

    public double findMinPrice(List<Integer> bookQuantities) {
        bookQuantities.removeIf(q -> q == 0);
        if (bookQuantities.isEmpty()) {
            return 0.0;//base condition
        }
        String key = bookQuantities.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        double minPrice = Double.MAX_VALUE;
        for (int setSize = Math.min(bookQuantities.size(), bookSize); setSize >= 1; setSize--) {
            List<Integer> remainingBooks = new ArrayList<>(bookQuantities);
            //System.out.println("Outer : " + remainingBooks);
            int count = 0;
            for (int i = 0; i < remainingBooks.size() && count < setSize; i++) {
                if (remainingBooks.get(i) > 0) {
                    remainingBooks.set(i, remainingBooks.get(i) - 1);
                    count++;
                }
                //System.out.println("Inner : " + remainingBooks);
            }
            if (count == setSize) {
                double price = (setSize * BOOK_PRICE * (1 - DISCOUNTS[setSize])) + findMinPrice(remainingBooks);
                minPrice = Math.min(minPrice, price);
            }
        }
        memo.put(key, minPrice);
        return minPrice;
    }


    public double calculatePrice(Map<String, Integer> books) {
        List<Integer> bookCounts = new ArrayList<>(books.values());
        bookSize = bookCounts.size();
        Collections.sort(bookCounts, Collections.reverseOrder());
        return findMinPrice(bookCounts);
    }

}

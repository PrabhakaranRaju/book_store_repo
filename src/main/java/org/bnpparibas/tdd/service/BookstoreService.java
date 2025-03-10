package org.bnpparibas.tdd.service;

import org.bnpparibas.tdd.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BookstoreService {

    private static final double BOOK_PRICE = 50;
    private static final double[] DISCOUNTS = {0.0, 0.0, 0.05, 0.10, 0.20, 0.25};


    public double calculatePrice(Map<String, Integer> books) {
        List<Integer> bookCounts = new ArrayList<>(books.values());
        //When first book becomes 0, loop will break. Below line prevents that.
        Collections.sort(bookCounts, Collections.reverseOrder());
        double totalPrice = 0.0;
        while (true) {  //to form groups
            int distinctBooks = 0;
            for (int i = 0; i < bookCounts.size(); i++) {
                if (bookCounts.get(i) > 0) {
                    bookCounts.set(i, bookCounts.get(i) - 1);
                    distinctBooks++;
                }
            }
            if (distinctBooks == 0) {
                break;
            }
            totalPrice += distinctBooks * BOOK_PRICE * (1 - DISCOUNTS[distinctBooks]);
        }
        return totalPrice;
    }

}

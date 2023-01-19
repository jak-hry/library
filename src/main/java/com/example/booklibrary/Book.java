package com.example.booklibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private int productionYear;
    private double rating;

    @Override
    public String toString() {
        return "title: \"" + title + "\", productionYear: \"" + productionYear +
                "\", rating: \"" + rating + "\"\n,";
    }
}

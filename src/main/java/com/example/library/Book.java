package com.example.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String title;
    private int productionYear;
    private double rating;

    @Override
    public String toString() {
        return "title: \"" + title + "\", productionYear: \"" + productionYear +
                "\", rating: \"" + rating + "\"\n,";
    }
}

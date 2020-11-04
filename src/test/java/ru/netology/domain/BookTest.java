package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Almost like a Buick", 1000, "Stephen King");

    @Test
    public void nameComparisonIfReal(){
        String text = "Almost like a Buick";
        assertTrue(book.matches(text));
    }

    @Test
    public void nameComparisonIfNotReal(){
        String text = "The Scarlet Flower";
        assertFalse(book.matches(text));
    }

    @Test
    public void comparisonOfTheAuthorIfReal(){
        String text = "Stephen King";
        assertTrue(book.matches(text));
    }

    @Test
    public void authorComparisonIfNotReal(){
        String text = "Sergey Aksakov";
        assertFalse(book.matches(text));
    }
}

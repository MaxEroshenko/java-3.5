package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product one = new Product(1, "name1", 223);


    @Test
    public void nameComparisonIfReal(){
        String text = "name1";
        assertTrue(one.matches(text));
    }

    @Test
    public void nameComparisonIfNotRealistic(){
        String text = "name5";
        assertFalse(one.matches(text));
    }

}
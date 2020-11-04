package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(1, "IphoneXR", 45000, "Apple");

    @Test
    public void nameComparisonIfReal(){
        String text = "IphoneXR";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void nameComparisonINotReal(){
        String text = "GalaxyNote";
        assertFalse(smartphone.matches(text));
    }

    @Test
    public void manufacturerComparisonIfReal(){
        String text = "Apple";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void manufacturerComparisonIfNotRealistic(){
        String text = "Samsung";
        assertFalse(smartphone.matches(text));
    }

}

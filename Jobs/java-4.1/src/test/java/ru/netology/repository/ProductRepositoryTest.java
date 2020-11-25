package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Зеленая миля", 10, "Стивен Кинг");
    private Book second = new Book(2, "Анна Каренина", 20, "Лев Толстой");
    private Book third = new Book(3, "Живой труп", 30, "Лев Толстой");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldThrowCheckedException() {
        int idToRemove = 4;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));

    }


    @Test
    public void shouldNotThrowCheckedException() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}

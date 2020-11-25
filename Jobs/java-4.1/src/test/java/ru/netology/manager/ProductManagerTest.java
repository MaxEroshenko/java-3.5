package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Зеленая миля", 350, "Стивен Кинг");
    private Book second = new Book(2, "Анна Каренина", 820, "Лев Толстой");
    private Book third = new Book(3, "Живой труп", 700, "Лев Толстой");
    private Smartphone smartphone1 = new Smartphone(1, "Apple", 110000, "США");
    private Smartphone smartphone2 = new Smartphone(2, "Huawei", 50000, "Китай");

    @BeforeEach
    public void setUp() {
        manager = new ProductManager(repository);
        manager.productAdd(first);
        manager.productAdd(second);
        manager.productAdd(smartphone1);
        manager.productAdd(smartphone2);
    }



    @Test
    void shouldSearchBookByNameIfExists() {
        String text = "Зеленая миля";

        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchBookByNameIfNotExists() {
        String text = "Война и мир";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthorIfExists() {
        String text = "Лев Толстой";

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchBookByAuthorIfNotExists() {
        String text = "Александр Пушкин";

        Book[] expected = new Book[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProductsWithSameAuthor() {
        manager.productAdd(third);
        String text = "Лев Толстой";

        Product[] expected = new Product[]{second, third};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNameIfExists() {
        String text = "Apple";

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchSmartphoneByNameIfNotExists() {
        String text = "Samsung";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturerIfExists() {
        String text = "США";

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchSmartphoneByManufacturerIfExists() {
        String text = "Украина";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
}
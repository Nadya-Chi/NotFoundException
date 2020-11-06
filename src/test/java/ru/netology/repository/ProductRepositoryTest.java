package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {
    ProductRepository productRepository = new ProductRepository();

    private Product first = new Book(1, "Poems", 250, "Pushkin");
    private Product second = new Book(2, "Prose", 250,  "Chekhov");
    private Product third = new TShirt(3, "Superman", 800, "M");

    @BeforeEach
    public void SetUp () {
        productRepository.save(first);
        productRepository.save(second);
        productRepository.save(third);
    }

    @Test
    void removeById() {
        int idToRemove = 3;
        productRepository.removeById(idToRemove);
        Product[] actual = productRepository.findAll();
        Product[] expected = new Product[] {first,second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdIfNotExist() {
        productRepository.removeById(5);
        assertThrows(NotFoundException.class, ()-> productRepository.removeById(4));
    }
}

package Repo;

import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Product book1 = new Book(111, "Java for Dummies", 150, "O'Reilly");
    Product smartphone = new Smartphone(112, "Samsa", 500, "Taiwan");
    Product book2 = new Book(113, "PostgreSQL", 200, "Luca Ferrari");

    @Test
    public void shouldFindAllItems() {
        Repository repo = new Repository();

        repo.add(book1);
        repo.add(smartphone);
        repo.add(book2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone, book2};

        assertArrayEquals(expected, actual);





    }

    @Test
    void shouldRemoveByIdNonEmpty() {
        Repository repo = new Repository();

        repo.add(book1);
        repo.add(smartphone);
        repo.add(book2);

        Product[] actual = repo.removeById(112);
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveByIdEmpty() {
        Repository repo = new Repository();

        repo.add(book1);


        Product[] actual = repo.removeById(111);
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveByNonExistingId() {
        Repository repo = new Repository();

        repo.add(book1);
        repo.add(smartphone);
        repo.add(book2);


        Product[] actual = repo.removeById(111);
        Product[] expected = {smartphone, book2};

        assertArrayEquals(expected, actual);

    }
}
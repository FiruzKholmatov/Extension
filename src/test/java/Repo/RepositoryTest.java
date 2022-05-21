package Repo;

import Exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Product book1 = new Book(111, "Java for Dummies", 150, "O'Reilly");
    Product smartphone = new Smartphone(112, "Samsung", 500, "Taiwan");
    Product book2 = new Book(113, "PostgreSQL", 200, "Luca Ferrari");
    Product book3 = new Book(114, "Java for Dummies", 180, "Barry Burd");

    @Test
    public void shouldFindAllItemsNonEmpty() {
        Repository repo = new Repository();

        repo.add(book1);
        repo.add(smartphone);
        repo.add(book2);
        repo.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone, book2, book3};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindAllItemsEmpty() {
        Repository repo = new Repository();


        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindAllItemsSole() {
        Repository repo = new Repository();

        repo.add(book1);


        Product[] actual = repo.findAll();
        Product[] expected = {book1};

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
    void shouldRemoveByIdLastItem() {
        Repository repo = new Repository();

        repo.add(book1);



        Product[] actual = repo.removeById(111);
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldThrowException() {
        Repository repo = new Repository();

        repo.add(book1);
        repo.add(smartphone);
        repo.add(book2);
        repo.add(book3);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(666);
        });


    }



}
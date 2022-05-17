package Manager;

import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    Product book1 = new Book(111, "Java for Dummies", 150, "O'Reilly");
    Product smartphone = new Smartphone(112, "Samsung", 500, "Taiwan");
    Product book2 = new Book(113, "PostgreSQL", 200, "Luca Ferrari");
    Product book3 = new Book(114, "Java for Dummies", 180, "Barry Burd");


    @Test

    public void shouldSearchStringInNonEmptyCart() {

        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(smartphone);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("a");
        Product[] expected = {book1, smartphone, book3};


        assertArrayEquals(expected, actual);


    }

    @Test

    public void shouldSearchStringInEmptyCart() {

        ProductManager manager = new ProductManager();


        Product[] actual = manager.searchBy("a");
        Product[] expected = {};


        assertArrayEquals(expected, actual);


    }

    @Test

    public void shouldSearchUnknownStringInNonEmptyCart() {

        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(smartphone);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("MySQL");
        Product[] expected = {};


        assertArrayEquals(expected, actual);


    }

    @Test

    public void shouldSearchUnknownStringInEmptyCart() {

        ProductManager manager = new ProductManager();


        Product[] actual = manager.searchBy("MySQL");
        Product[] expected = {};


        assertArrayEquals(expected, actual);


    }
}
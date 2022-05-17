package Repo;

import domain.Product;

public class Repository {

    protected Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public Product[] findAll() {

        Product[] result = new Product[products.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = products[i];
        }
        return products;
    }

    public Product[] removeById(int id) {

        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products)
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        products = tmp;
        return products;
    }


}

package product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(int id) {
        productList.removeIf(product -> product.getid() == id);
    }

    public Product getProductByName(String name) {
        for (Product product : productList) {
            if (product.getname().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void displayProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
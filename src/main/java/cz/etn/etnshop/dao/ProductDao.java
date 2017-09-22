package cz.etn.etnshop.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductDao {

    @Transactional(readOnly = true)
    List<Product> getProducts();

    void saveProduct(Product product);

    Product updateProduct(Product product);

    public boolean isProductExist(Product product);
}

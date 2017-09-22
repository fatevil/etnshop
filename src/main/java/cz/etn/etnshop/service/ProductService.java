package cz.etn.etnshop.service;

import cz.etn.etnshop.dao.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    @Transactional(readOnly = true)
    List<Product> getProducts();

    void saveProduct(Product product);

    Product updateProduct(Product product);

    public boolean isProductExist(Product product);


}

package cz.etn.etnshop.service;

import cz.etn.etnshop.dao.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ProductService {

    @Transactional(readOnly = true)
    List<Product> getProducts();

    @Transactional
    void saveProduct(Product product);

    Product updateProduct(Product product);

    @Transactional
    boolean serialNumberExist(Product product);

}

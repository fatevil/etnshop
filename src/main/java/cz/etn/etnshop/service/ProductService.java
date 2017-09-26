package cz.etn.etnshop.service;

import cz.etn.etnshop.dao.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductService {

    @Transactional(readOnly = true)
    List<Product> getProducts();

    void saveProduct(Product product);

    Product updateProduct(Product product);

    boolean serialNumberExist(Product product);

    boolean serialNumberExistAndIsNotMe(Product product);

    Product find(int id);

    List<Product> fullTextSearch(String word);

}

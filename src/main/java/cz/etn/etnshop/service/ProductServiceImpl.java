package cz.etn.etnshop.service;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        List<Product> products = productDao.getProducts();
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public boolean serialNumberExist(Product product) {
        return productDao.serialNumberExist(product.getSerialNumber());
    }


    @Override
    public boolean serialNumberExistAndIsNotMe(Product product) {
        return productDao.serialNumberExistAndIsNotMe(product.getSerialNumber(), product);
    }

    @Override
    public Product find(int id) {
        return productDao.find(id);
    }

    @Override
    public List<Product> fullTextSearch(String word) {
        return productDao.fullTextSearch(word);
    }


}

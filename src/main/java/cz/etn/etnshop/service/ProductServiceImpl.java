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

        products.stream().forEach(System.out::println);

        return products;
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean isProductExist(Product product) {
        return false;
    }

}

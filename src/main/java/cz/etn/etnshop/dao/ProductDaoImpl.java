package cz.etn.etnshop.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    @SuppressWarnings("unchecked")
    public List<Product> getProducts() {
        Criteria criteria = getSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    @Override
    public void saveProduct(Product product) {
        if (product == null) {
            return;
        }
        getSession().persist(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return (Product) getSession().merge(product);
    }

    @Override
    public boolean serialNumberExist(int serialNumber) {
        return (Long) getSession().createQuery("select count(p) from Product p where p.serialNumber = :value")
                .setParameter("value", serialNumber)
                .uniqueResult() > 0;
    }

    //TODO: .
    @Override
    public boolean serialNumberExistAndIsNotMe(int serialNumber, Product product) {
        return (Long) getSession().createQuery("select count(p) from Product p where p.serialNumber = ? AND p.id != ?")
                .setInteger(0, serialNumber)
                .setInteger(1, product.getId())
                .uniqueResult() > 0;
    }

    @Override
    public Product find(int id) {
        Object o = null;
        if ((o = getSession().get(Product.class, id)) != null) {
            return (Product) o;
        } else {
            return null;
        }
    }

    @Override
    public List<Product> fullTextSearch(String word) {
        String hqlQuery = "SELECT * FROM product WHERE MATCH(name) AGAINST ('" + word + "')";
        List<Object[]> objects = (List<Object[]>) getSession().createSQLQuery(hqlQuery).list();

        List<Product> products = new ArrayList<>();
        for (Object[] p : objects) {
            Product product = new Product();
            product.setId((int) p[0]);
            product.setName((String) p[1]);
            product.setSerialNumber((int) p[2]);
            products.add(product);
        }

        return products;
    }


}

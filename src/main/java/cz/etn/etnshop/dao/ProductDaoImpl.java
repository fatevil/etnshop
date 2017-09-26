package cz.etn.etnshop.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

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
        Query q = getSession().createSQLQuery("SELECT * FROM product WHERE serial_number = :value");
        q.setParameter("value", serialNumber);
        List list = q.list();
        return !list.isEmpty();
    }

    //TODO: .
    @Override
    public boolean serialNumberExistAndIsNotMe(int serialNumber, Product product) {
        Query q = getSession().createSQLQuery("SELECT * FROM product WHERE serial_number = " + serialNumber + " AND id != " + product.getId());
        List list = q.list();
        return !list.isEmpty();
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


}

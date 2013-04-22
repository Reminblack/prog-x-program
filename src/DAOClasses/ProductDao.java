/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Product;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class ProductDao implements Dao<Product>{

    
    public ProductDao(){
    }
    
    @Override
    public void create(Product newProduct){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newProduct);
    }
    
    @Override
    public void update(Product updatedProduct){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedProduct);
    }
    
    @Override
    public Product retrieve(Long product_id){
        return (Product)newHibernateUtil.getSessionFactory().getCurrentSession().get(Product.class, product_id);
    }
    
    @Override
    public List<Product> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Product").list();
    }
    
    @Override
    public void remove(Product deletedProduct){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedProduct);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Product;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class ProductDao implements Dao<Product>{
    
    private Session HibSession;
    
    public ProductDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(Product newProduct){
        HibSession.save(newProduct);
    }
    
    @Override
    public void update(Product updatedProduct){
        HibSession.update(updatedProduct);
    }
    
    @Override
    public Product retrieve(Long product_id){
        return (Product)HibSession.get(Product.class, product_id);
    }
    
    @Override
    public List<Product> retrieveAll(){
        return HibSession.createQuery("from Product").list();
    }
    
    @Override
    public void remove(Product deletedProduct){
        HibSession.delete(deletedProduct);
    }
}

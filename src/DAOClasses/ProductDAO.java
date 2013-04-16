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
public class ProductDAO {
    
    private Session HibSession;
    
    public ProductDAO(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void createNewProduct(Product newProduct){
        HibSession.save(newProduct);
    }
    
    public void updatePersoon(Product updatedProduct){
        HibSession.update(updatedProduct);
    }
    
    public Product getProduct(Long product_id){
        return (Product)HibSession.get(Product.class, product_id);
    }
    
    public List<Product> getAllProducts(){
        return HibSession.createQuery("from Product").list();
    }
    
    public void deleteProduct(Product deletedProduct){
        HibSession.delete(deletedProduct);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Product;
import supermarktmanager.ProductHistory;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class ProductHistoryDao implements Dao<ProductHistory>{
    
    private Session HibSession;
    
    public ProductHistoryDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(ProductHistory newProductHistory){
        HibSession.save(newProductHistory);
    }
    
    @Override
    public void update(ProductHistory updatedProductHistory){
        HibSession.update(updatedProductHistory);
    }
    
    @Override
    public ProductHistory retrieve(Long productHistory_id){
        return (ProductHistory)HibSession.get(ProductHistory.class, productHistory_id);
    }
        
    @Override
    public List<ProductHistory> retrieveAll(){
        return HibSession.createQuery("from ProductHistory").list();
    }
    
    @Override
    public void remove(ProductHistory deletedProductHistory){
        HibSession.delete(deletedProductHistory);
    }
    
    public List<ProductHistory> retrieveHistoryAssociatedWithAProduct(Product relatedProduct){
        return HibSession.createQuery("from ProductHistory where productId="+relatedProduct).list();
    }
}

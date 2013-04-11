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
public class ProductHistoryDAO {
    
    private Session HibSession;
    
    public ProductHistoryDAO(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void createNewProductHistory(ProductHistory newProductHistory){
        HibSession.save(newProductHistory);
    }
    
    public void updatePersoon(ProductHistory updatedProductHistory){
        HibSession.update(updatedProductHistory);
    }
    
    public ProductHistory getProductHistory(Long productHistory_id){
        return (ProductHistory)HibSession.get(ProductHistory.class, productHistory_id);
    }
    
    public List<ProductHistory> getAllProductHistoriesFromOneProduct(Product relatedProduct){
        return HibSession.createQuery("from ProductHistory where productId="+relatedProduct).list();
    }
    
    public List<ProductHistory> getAllProductHistories(){
        return HibSession.createQuery("from ProductHistory").list();
    }
    
    public void deleteProductHistory(ProductHistory deletedProductHistory){
        HibSession.delete(deletedProductHistory);
    }
}

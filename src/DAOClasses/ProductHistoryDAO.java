/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Product;
import supermarktmanager.ProductHistory;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class ProductHistoryDao implements Dao<ProductHistory>{
    
    public ProductHistoryDao(){
    }
    
    @Override
    public void create(ProductHistory newProductHistory){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newProductHistory);
    }
    
    @Override
    public void update(ProductHistory updatedProductHistory){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedProductHistory);
    }
    
    @Override
    public ProductHistory retrieve(Long productHistory_id){
        return (ProductHistory)newHibernateUtil.getSessionFactory().getCurrentSession().get(ProductHistory.class, productHistory_id);
    }
        
    @Override
    public List<ProductHistory> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from ProductHistory").list();
    }
    
    @Override
    public void remove(ProductHistory deletedProductHistory){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedProductHistory);
    }
    
    public List<ProductHistory> retrieveHistoryAssociatedWithAProduct(Product relatedProduct){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from ProductHistory where productId="+relatedProduct).list();
    }
}

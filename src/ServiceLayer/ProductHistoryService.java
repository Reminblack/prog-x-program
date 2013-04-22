/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.Dao;
import DAOClasses.ProductHistoryDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Product;
import supermarktmanager.ProductHistory;

/**
 *
 * @author Bart
 */
public class ProductHistoryService {
    private ProductHistoryDao productHistoryDao;
    private Session hibSession;
    
    public void setProductHistoryDAO(Dao productHistoryDao){
        this.productHistoryDao = (ProductHistoryDao)productHistoryDao;
    }
    
    public void addNewProductHistory(Product associatedProduct) throws RuntimeException{
        ProductHistory newProductHistory = new ProductHistory();
        newProductHistory.setProductId(associatedProduct);
        newProductHistory.setPrijs(associatedProduct.getPrijs());
        productHistoryDao.create(newProductHistory);
    }
    
    public void updateProductHistory(ProductHistory updatedProductHistory){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            productHistoryDao.update(updatedProductHistory);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public ProductHistory getProductHistoryById(Long productHistory_id)
    {
        ProductHistory foundProductHistory = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundProductHistory = productHistoryDao.retrieve(productHistory_id);
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundProductHistory;
    }
    
    public List<ProductHistory> getAllProductHistories()
    {
        List<ProductHistory> foundProductHistories = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundProductHistories = new ArrayList(productHistoryDao.retrieveAll());
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundProductHistories;
    }
    
    public void deleteAProductHistory(ProductHistory productHistory){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            productHistoryDao.remove(productHistory);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public List<ProductHistory> getAllHistoryAssociatedWithProduct(Product associatedProduct){
        return hibSession.createQuery("from History WHERE product='"+associatedProduct+"'").list();
    }
}

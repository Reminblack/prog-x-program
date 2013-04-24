/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DaoLayer.ProductDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import Entity.Product;
import Entity.ProductHistory;

/**
 *
 * @author Remco
 */
public class ProductService {
    
    private Session hibSession;
    private ProductDao productDao;
    private ProductHistoryService historyService;
    private ContainerService containerService;
    
    public void setProductDao(ProductDao productDao)
    {
        this.productDao = productDao;
    }
    
    public void setProductServices(ProductHistoryService historyService, ContainerService containerService){
        this.historyService = historyService;
        this.containerService = containerService;
    }
    
    public void createProduct(Product p) {
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            productDao.create(p);
            historyService.addNewProductHistory(p);
            hibSession.getTransaction().commit();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            e.getStackTrace();
            hibSession.getTransaction().rollback();
        }
    }
    
    public void updateProduct(Product updatedProduct){
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            Product oldProduct = productDao.retrieve(updatedProduct.getId());
            if (oldProduct.getPrijs() != updatedProduct.getPrijs()) {
                ProductHistory currentGeschiedenis = null;
                for (ProductHistory history : historyService.getAllHistoryAssociatedWithProduct(updatedProduct)) {
                    if (history.getDateEind() == null) {
                        currentGeschiedenis = history;
                    }
                }
                if(currentGeschiedenis == null){
                    System.out.println("CurrentGeschiedenis is null");
                }
                currentGeschiedenis.setDateEind(new Date());
                historyService.addNewProductHistory(updatedProduct);
            }
            if (updatedProduct.getContainer() != oldProduct.getContainer()) {
                oldProduct.getContainer().removeProduct(updatedProduct);
                updatedProduct.getContainer().addProduct(updatedProduct);
                containerService.updateContainer(oldProduct.getContainer());
                containerService.updateContainer(updatedProduct.getContainer());
            }
            productDao.update(updatedProduct);
            hibSession.flush();
        } catch (RuntimeException e) {
            e.getStackTrace();
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }
    
    public Product getProductById(Long product_id)
    {
        Product foundProduct = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundProduct = productDao.retrieve(product_id);
        } catch(RuntimeException e){
            e.getStackTrace();
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundProduct;
    }
    
    public List<Product> getAllProducts()
    {
        List<Product> foundProducts = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundProducts = new ArrayList(productDao.retrieveAll());
        } catch(RuntimeException e){
            e.getStackTrace();
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundProducts;
    }
    
    public void deleteProduct(Product p) {
        try {
            hibSession = ServiceLayer.StaticContainer.getSession();
            hibSession.beginTransaction();
            
            historyService.getAllProductHistories();
            for (ProductHistory ph : historyService.getAllHistoryAssociatedWithProduct(p)) {
                historyService.deleteAProductHistory(ph);
            }
            productDao.remove(p);            
            hibSession.flush();
        } catch (RuntimeException e) {
            e.getStackTrace();
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }
    
    public void verkoopProduct(Product product, int aantal) {
        if ((product.getAantal() - aantal) >= 0) {
            try {
                hibSession = StaticContainer.getSession();
                hibSession.beginTransaction();
                product.setAantal(product.getAantal() - aantal);
                ProductHistory currentGeschiedenis = null;
                for (ProductHistory history : historyService.getAllHistoryAssociatedWithProduct(product)) {
                    if (history.getDateEind() == null) {
                        currentGeschiedenis = history;
                    }
                }
                if(currentGeschiedenis == null){
                    System.out.println("CurrentGeschiedenis is null");
                }
                currentGeschiedenis.setAantal(currentGeschiedenis.getAantal() + aantal);
                productDao.update(product);
                historyService.updateProductHistory(currentGeschiedenis);
                hibSession.flush();
            } catch (RuntimeException e) {
                e.getStackTrace();
                System.out.println("Exception e has occured: " + e);
                hibSession.getTransaction().rollback();
            } finally {
                hibSession.close();
            }
        }
    }
}

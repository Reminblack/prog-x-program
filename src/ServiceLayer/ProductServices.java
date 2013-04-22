/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.ContainerDao;
import DAOClasses.ProductDao;
import DAOClasses.ProductHistoryDao;
import supermarktmanager.*;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Remco
 */
public class ProductServices {
    
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
            
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }
    
    public void deleteProduct(Product p) {
        try {
            hibSession = ServiceLayer.StaticContainer.getSession();
            hibSession.beginTransaction();
            
            //supermarktmanager.ProductHistory[] allHistory = new supermarktmanager.ProductHistory[]{};
            allHistory = historyDao.retrieveHistoryAssociatedWithAProduct(p).toArray(allHistory);
            historyService.getAllProductHistories();
            for (ProductHistory ph : productHistoryService.retrieveHistoryAssociatedWithAProduct(p)) {
                historyDao.remove(ph);
            }
            productDao.remove(p);            
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }
    
    
    
    public void saveChanges(supermarktmanager.Product product, Container c) {
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            supermarktmanager.Product compare = productDao.retrieve(product.getId());
            if (compare.getPrijs() != product.getPrijs()) {
                supermarktmanager.ProductHistory[] allGeschiedenis = new supermarktmanager.ProductHistory[]{};
                allGeschiedenis = historyDao.retrieveHistoryAssociatedWithAProduct(product).toArray(allGeschiedenis);
                
                supermarktmanager.ProductHistory currentGeschiedenis = allGeschiedenis[0];
                for (supermarktmanager.ProductHistory history : allGeschiedenis) {
                    if (history.getDateEind() == null) {
                        currentGeschiedenis = history;
                    }
                }
                Date date = new Date();
                currentGeschiedenis.setDateEind(date);
                supermarktmanager.ProductHistory newHistory = new supermarktmanager.ProductHistory();
                newHistory.setPrijs(product.getPrijs());
                newHistory.setProductId(product);
                historyDao.update(currentGeschiedenis);
                historyDao.create(newHistory);
            }
            if (product.getRek() != compare.getRek()) {
                compare.getRek().removeProduct(product);
                product.getRek().addProduct(product);
                containerDao.update(compare.getRek());
                containerDao.update(product.getRek());
            }
            productDao.update(product);
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }
    
    public void verkoopProduct(Product product, int aantal) {
        try {
            hibSession = ServiceLayer.StaticContainer.getSession();
            hibSession.beginTransaction();
            if ((product.getAantal() - aantal) >= 0) {
                product.setAantal(product.getAantal() - aantal);
                
                supermarktmanager.ProductHistory[] allGeschiedenis = new supermarktmanager.ProductHistory[]{};
                allGeschiedenis = historyDao.retrieveHistoryAssociatedWithAProduct(product).toArray(allGeschiedenis);
                
                supermarktmanager.ProductHistory currentGeschiedenis = allGeschiedenis[0];
                for (supermarktmanager.ProductHistory history : allGeschiedenis) {
                    if (history.getDateEind() == null) {
                        currentGeschiedenis = history;
                    }
                }
                currentGeschiedenis.setAantal(currentGeschiedenis.getAantal() + aantal);
                productDao.update(product);
                historyDao.update(currentGeschiedenis);
                
            }
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }
}

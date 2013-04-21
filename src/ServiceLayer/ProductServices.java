/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.DAOContainer;
import supermarktmanager.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Remco
 */
public class ProductServices {
    
    public void saveChanges(supermarktmanager.Product product)
    {
        DAOContainer.session.beginTransaction();
        supermarktmanager.Product compare = DAOContainer.product.getProduct(product.getId());
        if(compare.getPrijs() != product.getPrijs())
        {
            supermarktmanager.ProductHistory[] allGeschiedenis = new supermarktmanager.ProductHistory[]{};
            allGeschiedenis = DAOContainer.history.getAllProductHistoriesFromOneProduct(product).toArray(allGeschiedenis);
            
            supermarktmanager.ProductHistory currentGeschiedenis = allGeschiedenis[0];
            for(supermarktmanager.ProductHistory history : allGeschiedenis)
            {
                if(history.getDateEind() == null)
                {
                    currentGeschiedenis = history;
                }
            }
            Date date = new Date();
            currentGeschiedenis.setDateEind(date);
            supermarktmanager.ProductHistory newHistory = new supermarktmanager.ProductHistory();
            newHistory.setPrijs(product.getPrijs());
            newHistory.setProductId(product);
            DAOContainer.session.save(currentGeschiedenis);
            DAOContainer.session.save(newHistory);
            DAOContainer.session.save(product);
        }
        DAOContainer.session.getTransaction().commit();
    }
    
    public void verplaatsProduct(Product product, Container container){
        DAOContainer.session.beginTransaction();
        product.setRek(container);
        DAOContainer.session.save(product);
        DAOContainer.session.getTransaction().commit();
    }
    
    
    public void verkoopProduct(Product product, int aantal)
    {
        DAOContainer.session.beginTransaction();
        if((product.getAantal()-aantal) >= 0)
        {
        product.setAantal(product.getAantal()-aantal);
        
        supermarktmanager.ProductHistory[] allGeschiedenis = new supermarktmanager.ProductHistory[]{};
            allGeschiedenis = DAOContainer.history.getAllProductHistoriesFromOneProduct(product).toArray(allGeschiedenis);
            
            supermarktmanager.ProductHistory currentGeschiedenis = allGeschiedenis[0];
            for(supermarktmanager.ProductHistory history : allGeschiedenis)
            {
                if(history.getDateEind() == null)
                {
                    currentGeschiedenis = history;
                }
            }
            currentGeschiedenis.setAantal(currentGeschiedenis.getAantal()+aantal);
        DAOContainer.session.save(product);
        DAOContainer.session.save(currentGeschiedenis);

        }
        DAOContainer.session.getTransaction().commit();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import supermarktmanager.newHibernateUtil;
import DAOClasses.*;

/**
 *
 * @author Remco
 */
public class ProductServices {
    
    public void saveChanges(supermarktmanager.Product product)
    {
        DAOContainer.session.beginTransaction();
        
        
        DAOContainer.session.getTransaction().commit();
    }
    
}

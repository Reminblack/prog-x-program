/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import org.hibernate.Session;
import supermarktmanager.*;

/**
 *
 * @author Bart
 */
public class PersoonDAO {
    
    private Session HibSession;
    
    public PersoonDAO(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void createNewPersoon(Persoon newEmployee){
        HibSession.save(newEmployee);
    }
    
    public void updatePersoon(Persoon newEmployee){
        HibSession.update(newEmployee);
    }
    
    public Persoon getPersoon(){
        return (Persoon)HibSession.get(Persoon.class, HibSession);
    }
}

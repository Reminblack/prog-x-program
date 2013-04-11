/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
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
    
    protected void createNewPersoon(Persoon newEmployee){
        HibSession.save(newEmployee);
    }
    
    protected void updatePersoon(Persoon updatedEmployee){
        HibSession.update(updatedEmployee);
    }
    
    protected Object getPersoon(Long employee_id){
        return HibSession.get(Persoon.class, employee_id);
    }
    
    protected List getAllPersonen(String employeeType){
        return HibSession.createQuery("from "+employeeType).list();
    }
    
    protected void deletePersoon(Persoon deletedPersoon){
        HibSession.delete(deletedPersoon);
    }
}

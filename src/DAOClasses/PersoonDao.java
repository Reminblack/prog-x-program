/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.*;

/**
 *
 * @author Bart
 */
public abstract class PersoonDao{
    
    public PersoonDao(){
    }
    
    protected void createNewPersoon(Persoon newEmployee){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newEmployee);
    }
    
    protected void updatePersoon(Persoon updatedEmployee){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedEmployee);
    }
    
    protected Object getPersoon(Long employee_id){
        return newHibernateUtil.getSessionFactory().getCurrentSession().get(Persoon.class, employee_id);
    }
    
    protected List getAllPersonen(String employeeType){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from "+employeeType).list();
    }
    
    protected void deletePersoon(Persoon deletedPersoon){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedPersoon);
    }
}

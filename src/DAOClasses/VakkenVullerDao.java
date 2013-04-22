/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.Session;
import supermarktmanager.VakkenVuller;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class VakkenVullerDao implements Dao<VakkenVuller>{
    
    public VakkenVullerDao(){
    }
    
    @Override
    public void create(VakkenVuller newVakkenVuller){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newVakkenVuller);
    }
    
    @Override
    public void update(VakkenVuller updatedVakkenVuller){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedVakkenVuller);
    }
    
    @Override
    public VakkenVuller retrieve(Long vakkenVuller_id){
        return (VakkenVuller) newHibernateUtil.getSessionFactory().getCurrentSession().get(VakkenVuller.class, vakkenVuller_id);
    }
    
    @Override
    public List<VakkenVuller> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from VakkenVuller").list();
    }
    
    @Override
    public void remove(VakkenVuller deletedVakkenVuller){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedVakkenVuller);
    }
}

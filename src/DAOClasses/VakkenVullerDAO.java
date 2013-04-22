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
    
    private Session HibSession;
    
    public VakkenVullerDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(VakkenVuller newVakkenVuller){
        HibSession.save(newVakkenVuller);
    }
    
    @Override
    public void update(VakkenVuller updatedVakkenVuller){
        HibSession.update(updatedVakkenVuller);
    }
    
    @Override
    public VakkenVuller retrieve(Long vakkenVuller_id){
        return (VakkenVuller) HibSession.get(VakkenVuller.class, vakkenVuller_id);
    }
    
    @Override
    public List<VakkenVuller> retrieveAll(){
        return HibSession.createQuery("from VakkenVuller").list();
    }
    
    @Override
    public void remove(VakkenVuller deletedVakkenVuller){
        HibSession.delete(deletedVakkenVuller);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.VakkenVuller;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class VakkenVullerDao extends PersoonDao implements Dao<VakkenVuller>{
    
    public VakkenVullerDao(){
    }
    
    @Override
    public void create(VakkenVuller newVakkenVuller){
        super.createNewPersoon(newVakkenVuller);
    }
    
    @Override
    public void update(VakkenVuller updatedVakkenVuller){
        super.updatePersoon(updatedVakkenVuller);
    }
    
    @Override
    public VakkenVuller retrieve(Long vakkenVuller_id){
        return (VakkenVuller) super.getPersoon(vakkenVuller_id);
    }
    
    @Override
    public List<VakkenVuller> retrieveAll(){
        return super.getAllPersonen("VakkenVuller");
    }
    
    @Override
    public void remove(VakkenVuller deletedVakkenVuller){
        super.deletePersoon(deletedVakkenVuller);
    }
}

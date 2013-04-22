/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Slager;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class SlagerDao extends PersoonDao implements Dao<Slager>{
   
    public SlagerDao(){
    }
    
    @Override
    public void create(Slager newSlager){
        super.createNewPersoon(newSlager);
    }
    
    @Override
    public void update(Slager updatedSlager){
        super.updatePersoon(updatedSlager);
    }
    
    @Override
    public Slager retrieve(Long slager_id){
        return (Slager) super.getPersoon(slager_id);
    }
    
    @Override
    public List<Slager> retrieveAll(){
        return super.getAllPersonen("Slager");
    }
    
    @Override
    public void remove(Slager deletedSlager){
        super.deletePersoon(deletedSlager);
    }
}

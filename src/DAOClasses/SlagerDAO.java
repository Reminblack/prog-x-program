/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Slager;
import supermarktmanager.VakkenVuller;

/**
 *
 * @author Bart
 */
public class SlagerDAO extends PersoonDAO{
    
    public SlagerDAO(){
        
    }
    
    public void createNewSlager(Slager newSlager){
        super.createNewPersoon(newSlager);
    }
    
    public void updateSlager(Slager updatedSlager){
        super.updatePersoon(updatedSlager);
    }
    
    public VakkenVuller getKassiere(Long Slager_id){
        return (Slager) super.getPersoon(Slager_id);
    }
    
    public List<Slager> getAllSlagers(){
        return super.getAllPersonen("Slager");
    }
}

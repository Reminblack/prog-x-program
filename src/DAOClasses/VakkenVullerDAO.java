/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.VakkenVuller;

/**
 *
 * @author Bart
 */
public class VakkenVullerDAO extends PersoonDAO{
    
    public VakkenVullerDAO(){
         
    }
    
    public void createNewVakkenVuller(VakkenVuller newVakkenVuller){
        super.createNewPersoon(newVakkenVuller);
    }
    
    public void updateVakkenVuller(VakkenVuller updatedVakkenVuller){
        super.updatePersoon(updatedVakkenVuller);
    }
    
    public VakkenVuller getVakkenVuller(Long vakkenVuller_id){
        return (VakkenVuller) super.getPersoon(vakkenVuller_id);
    }
    
    public List<VakkenVuller> getAllVakkenVullers(){
        return super.getAllPersonen("VakkenVuller");
    }
    
    public void deleteProduct(VakkenVuller deletedVakkenVuller){
        super.deletePersoon(deletedVakkenVuller);
    }
}

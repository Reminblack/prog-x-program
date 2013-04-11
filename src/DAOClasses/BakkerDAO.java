/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Bakker;
import supermarktmanager.VakkenVuller;

/**
 *
 * @author Bart
 */
public class BakkerDAO extends PersoonDAO{
    
    public BakkerDAO(){
        
    }
    
    public void createNewBakker(Bakker newBakker){
        super.createNewPersoon(newBakker);
    }
    
    public void updateBakker(Bakker updatedBakker){
        super.updatePersoon(updatedBakker);
    }
    
    public VakkenVuller getBakker(Long Bakker_id){
        return (Bakker) super.getPersoon(Bakker_id);
    }
    
    public List<Bakker> getAllBakkers(){
        return super.getAllPersonen("Bakker");
    }
}

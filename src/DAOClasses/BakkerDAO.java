/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Bakker;

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
    
    public Bakker getBakker(Long Bakker_id){
        return (Bakker) super.getPersoon(Bakker_id);
    }
    
    public List<Bakker> getAllBakkers(){
        return super.getAllPersonen("Bakker");
    }
    
    public void deleteBakker(Bakker deletedBakker){
        super.getAllPersonen("Bakker");
    }
}

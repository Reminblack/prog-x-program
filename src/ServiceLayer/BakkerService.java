/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DaoLayer.Dao;
import java.util.ArrayList;
import java.util.List;
import Entity.Bakker;
import Entity.Persoon;

/**
 *
 * @author Bart
 */
public class BakkerService extends PersoonService{
    private boolean isSet = false;
    public void setService(Dao PersoonDao){
        if(!isSet){
            super.setDao(PersoonDao);
            isSet = true;
        }
    }
    
    public void addNewBakker(Bakker newBakker){
        super.addPersoon(newBakker);
    }
    
    public void updateBakker(Bakker updatedBakker){
        super.updatePersoon(updatedBakker);
    }
    
    public Bakker getBakkerById(Long bakker_id)
    {
        Persoon foundEmployee = super.getPersoonById(bakker_id);
        if(foundEmployee instanceof Bakker){
            return (Bakker)foundEmployee;
        } else {
            System.out.println("This is not a Bakker.");
        }
        return null;
    }
    
    public List<Bakker> getAllBakkers(){
        List<Bakker> foundBakkers = new ArrayList();
        for(Persoon currentEmployee : super.getAllPersoons()){
            if(currentEmployee instanceof Bakker){
                foundBakkers.add((Bakker)currentEmployee);
            }
        }
        return foundBakkers;
    }
    
    public void deleteABakker(Bakker bakker){
        super.deleteAPersoon(bakker);
    }
}

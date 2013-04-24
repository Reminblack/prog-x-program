/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DaoLayer.Dao;
import java.util.ArrayList;
import java.util.List;
import Entity.Persoon;
import Entity.Slager;

/**
 *
 * @author Bart
 */
public class SlagerService extends PersoonService{
    private boolean isSet = false;
    public void setService(Dao PersoonDao){
        if(!isSet){
            super.setDao(PersoonDao);
            isSet = true;
        }
    }
    
    public void addNewSlager(Slager newSlager){
        super.addPersoon(newSlager);
    }
    
    public void updateSlager(Slager updatedSlager){
        super.updatePersoon(updatedSlager);
    }
    
    public Slager getSlagerById(Long slager_id)
    {
        Persoon foundEmployee = super.getPersoonById(slager_id);
        if(foundEmployee instanceof Slager){
            return (Slager)foundEmployee;
        } else {
            System.out.println("This is not a Slager.");
        }
        return null;
    }
    
    public List<Slager> getAllSlagers(){
        List<Slager> foundSlagers = new ArrayList();
        for(Persoon currentEmployee : super.getAllPersoons()){
            if(currentEmployee instanceof Slager){
                foundSlagers.add((Slager)currentEmployee);
            }
        }
        return foundSlagers;
    }
    
    public void deleteASlager(Slager slager){
        super.deleteAPersoon(slager);
    }
}

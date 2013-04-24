/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DaoLayer.Dao;
import java.util.ArrayList;
import java.util.List;
import Entity.Persoon;
import Entity.VakkenVuller;

/**
 *
 * @author Bart
 */
public class VakkenVullerService extends PersoonService{
    private boolean isSet = false;
    public void setService(Dao PersoonDao){
        if(!isSet){
            super.setDao(PersoonDao);
            isSet = true;
        }
    }
    
    public void addNewVakkenVuller(VakkenVuller newVakkenVuller){
        super.addPersoon(newVakkenVuller);
    }
    
    public void updateVakkenVuller(VakkenVuller updatedVakkenVuller){
        super.updatePersoon(updatedVakkenVuller);
    }
    
    public VakkenVuller getVakkenVullerById(Long vakkenVuller_id)
    {
        Persoon foundEmployee = super.getPersoonById(vakkenVuller_id);
        if(foundEmployee instanceof VakkenVuller){
            return (VakkenVuller)foundEmployee;
        } else {
            System.out.println("This is not a VakkenVuller.");
        }
        return null;
    }
    
    public List<VakkenVuller> getAllVakkenVullers(){
        List<VakkenVuller> foundVakkenVullers = new ArrayList();
        for(Persoon currentEmployee : super.getAllPersoons()){
            if(currentEmployee instanceof VakkenVuller){
                foundVakkenVullers.add((VakkenVuller)currentEmployee);
            }
        }
        return foundVakkenVullers;
    }
    
    public void deleteAVakkenVuller(VakkenVuller vakkenVuller){
        super.deleteAPersoon(vakkenVuller);
    }
}

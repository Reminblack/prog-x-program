/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarktmanager;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author niet-Ben
 */
@Entity
public class VakkenVuller extends Persoon {

    @ManyToMany
    private List<Locatie> werkplekken = new ArrayList<Locatie>();
    
    public VakkenVuller() {
        
    }
    
    public void addLocation(Locatie newLocation){
        werkplekken.add(newLocation);
    }
    
    public void removeLocation(Locatie removeLocation){
        werkplekken.remove(removeLocation);
    }
    
    public List<Locatie> getLocations(){
        return werkplekken;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Remco
 */

@Entity
public class Bakker extends Persoon {
    
    public Bakker(){
        
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

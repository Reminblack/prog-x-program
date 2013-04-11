/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Kassiere;
import supermarktmanager.VakkenVuller;

/**
 *
 * @author Bart
 */
public class KassiereDAO extends PersoonDAO{
    
    public KassiereDAO(){
        
    }
    
    public void createNewBakker(Kassiere newKassiere){
        super.createNewPersoon(newKassiere);
    }
    
    public void updateBakker(Kassiere updatedKassiere){
        super.updatePersoon(updatedKassiere);
    }
    
    public VakkenVuller getKassiere(Long Kassiere_id){
        return (Kassiere) super.getPersoon(Kassiere_id);
    }
    
    public List<Kassiere> getAllKassieres(){
        return super.getAllPersonen("Kassiere");
    }
}

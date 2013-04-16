/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Kassiere;

/**
 *
 * @author Bart
 */
public class KassiereDAO extends PersoonDAO{
    
    public KassiereDAO(){
        
    }
    
    public void createNewKassiere(Kassiere newKassiere){
        super.createNewPersoon(newKassiere);
    }
    
    public void updateKassiere(Kassiere updatedKassiere){
        super.updatePersoon(updatedKassiere);
    }
    
    public Kassiere getKassiere(Long kassiere_id){
        return (Kassiere) super.getPersoon(kassiere_id);
    }
    
    public List<Kassiere> getAllKassieres(){
        return super.getAllPersonen("Kassiere");
    }
    
    public void deleteKassiere(Kassiere deletedKassiere){
        super.deletePersoon(deletedKassiere);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Kassiere;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class KassiereDao extends PersoonDao implements Dao<Kassiere>{
    
    public KassiereDao(){
    }
    
    @Override
    public void create(Kassiere newKassiere){
        super.createNewPersoon(newKassiere);
    }
    
    @Override
    public void update(Kassiere updatedKassiere){
        super.updatePersoon(updatedKassiere);
    }
    
    @Override
    public Kassiere retrieve(Long kassiere_id){
        return (Kassiere) super.getPersoon(kassiere_id);
    }
    
    @Override
    public List<Kassiere> retrieveAll(){
        return super.getAllPersonen("Kassiere");
    }
    
    @Override
    public void remove(Kassiere deletedKassiere){
        super.deletePersoon(deletedKassiere);
    }
}

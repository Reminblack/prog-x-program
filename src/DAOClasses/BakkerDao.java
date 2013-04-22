/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Bakker;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class BakkerDao extends PersoonDao implements Dao<Bakker>{
   
    public BakkerDao(){
        
    }
    
    @Override
    public void create(Bakker newBakker){
        super.createNewPersoon(newBakker);
    }
    
    @Override
    public void update(Bakker updatedBakker){
        super.updatePersoon(updatedBakker);
    }
    
    @Override
    public Bakker retrieve(Long Bakker_id){
        return (Bakker) super.getPersoon(Bakker_id);
    }
    
    @Override
    public List<Bakker> retrieveAll(){
        return super.getAllPersonen("Bakker");
    }
    
    @Override
    public void remove(Bakker deletedBakker){
        super.deletePersoon(deletedBakker);
    }
}

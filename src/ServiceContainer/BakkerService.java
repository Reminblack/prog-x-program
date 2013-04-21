/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.BakkerDao;
import java.util.List;
import supermarktmanager.Bakker;

/**
 *
 * @author Bart
 */
public class BakkerService {
    private BakkerDao bakkerDao;
    
    public void setBakkerDAO(BakkerDao bakkerDao){
        this.bakkerDao = bakkerDao;
    }
    
    public void addNewBakker(Bakker newBakker){
        bakkerDao.create(newBakker);
    }
    
    public void updateBakker(Bakker updatedBakker){
        bakkerDao.update(updatedBakker);
    }
    
    public Bakker getBakkerById(Long bakker_id)
    {
        return bakkerDao.retrieve(bakker_id);
    }
    
    public List<Bakker> getAllBakkers()
    {
        return bakkerDao.retrieveAll();
    }
    
    public void deleteABakker(Bakker bakker){
        bakkerDao.remove(bakker);
    }
}

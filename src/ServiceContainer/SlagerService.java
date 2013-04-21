/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.SlagerDao;
import java.util.List;
import supermarktmanager.Slager;

/**
 *
 * @author Bart
 */
public class SlagerService {
    private SlagerDao slagerDao;
    
    public void setSlagerDAO(SlagerDao slagerDao){
        this.slagerDao = slagerDao;
    }
    
    public void addNewSlager(Slager newSlager){
        slagerDao.create(newSlager);
    }
    
    public void updateSlager(Slager updatedSlager){
        slagerDao.update(updatedSlager);
    }
    
    public Slager getSlagerById(Long slager_id)
    {
        return slagerDao.retrieve(slager_id);
    }
    
    public List<Slager> getAllSlagers()
    {
        return slagerDao.retrieveAll();
    }
    
    public void deleteASlager(Slager slager){
        slagerDao.remove(slager);
    }
}

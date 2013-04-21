/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.VakkenVullerDao;
import java.util.List;
import supermarktmanager.VakkenVuller;

/**
 *
 * @author Bart
 */
public class VakkenVullerService {
    private VakkenVullerDao vakkenvullerDao;
    
    public void setVakkenVullerDao(VakkenVullerDao vakkenvullerDao){
        this.vakkenvullerDao = vakkenvullerDao;
    }
    
    public void addNewVakkenVuller(VakkenVuller newVakkenVuller){
        vakkenvullerDao.create(newVakkenVuller);
    }
    
    public void updateVakkenVuller(VakkenVuller updatedVakkenVuller){
        vakkenvullerDao.update(updatedVakkenVuller);
    }
    
    public VakkenVuller getVakkenVullerById(Long vakkenVuller_id)
    {
        return vakkenvullerDao.retrieve(vakkenVuller_id);
    }
    
    public List<VakkenVuller> getAllVakkenVullers()
    {
        return vakkenvullerDao.retrieveAll();
    }
    
    public void deleteAVakkenVuller(VakkenVuller vakkenVuller){
        vakkenvullerDao.remove(vakkenVuller);
    }
}

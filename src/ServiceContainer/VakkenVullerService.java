/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.VakkenVullerDao;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Locatie;
import supermarktmanager.VakkenVuller;

/**
 *
 * @author Bart
 */
public class VakkenVullerService {
    private VakkenVullerDao vakkenvullerDao;
    private Session hibSession;
    
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
    
    public void assignVakkenVullerToLocation(Long vakkenvuller_id, Locatie newLocation){
        hibSession = StaticContainer.getSession();
        hibSession.beginTransaction();
        VakkenVuller foundVakkenVuller = getVakkenVullerById(vakkenvuller_id);
        foundVakkenVuller.addLocation(newLocation);
        vakkenvullerDao.update(foundVakkenVuller);
        hibSession.getTransaction().commit();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.VakkenVullerDao;

/**
 *
 * @author Bart
 */
public class VakkenVullerService {
    private VakkenVullerDao vakkenvullerDao;
    
    public void setBakkerDAO(VakkenVullerDao vakkenvullerDao){
        this.vakkenvullerDao = vakkenvullerDao;
    }
}

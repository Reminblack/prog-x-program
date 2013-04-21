/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.BakkerDao;

/**
 *
 * @author Bart
 */
public class BakkerService {
    private BakkerDao bakkerDao;
    
    public void setBakkerDAO(BakkerDao bakkerDao){
        this.bakkerDao = bakkerDao;
    }
}

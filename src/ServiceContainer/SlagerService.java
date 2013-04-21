/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.SlagerDao;

/**
 *
 * @author Bart
 */
public class SlagerService {
    private SlagerDao slagerDao;
    
    public void setBakkerDAO(SlagerDao slagerDao){
        this.slagerDao = slagerDao;
    }
}

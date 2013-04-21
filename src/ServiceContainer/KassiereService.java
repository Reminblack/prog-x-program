/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.KassiereDao;

/**
 *
 * @author Bart
 */
public class KassiereService {
    private KassiereDao kassiereDao;
    
    public void setBakkerDAO(KassiereDao kassiereDao){
        this.kassiereDao = kassiereDao;
    }
}

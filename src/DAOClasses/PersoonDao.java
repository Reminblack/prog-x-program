/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.*;

/**
 *
 * @author Bart
 */
public class PersoonDao implements Dao<Persoon>{
    //Masking Dao for all employees
    
    @Override
    public void create(Persoon newObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Persoon updatedObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Persoon retrieve(Long object_id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Persoon> retrieveAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Persoon removeObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

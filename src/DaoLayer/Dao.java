/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoLayer;

import java.util.List;

/**
 *
 * @author Bart
 */
public interface Dao<T> {
    
    public void create(T newObject);
    
    public void update(T updatedObject);
    
    public T retrieve(Long object_id);
    
    public List<T> retrieveAll();
    
    public void remove(T removeObject);
}

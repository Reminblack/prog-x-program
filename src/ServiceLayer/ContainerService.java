/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;
import DAOClasses.DAOContainer;
import supermarktmanager.*;
import java.util.List;
/**
 *
 * @author Remco
 */
public class ContainerService {
    public void createContainer(Container c){
        DAOContainer.session.beginTransaction();
        
    }
}

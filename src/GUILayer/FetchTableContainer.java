/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILayer;

import java.util.List;
import Entity.Container;

/**
 *
 * @author Bart
 */
public class FetchTableContainer implements IFetchTable<Container> {
    
    @Override
    public Object[][] Fetch(List<Container> fetchedList){
        if(!fetchedList.isEmpty()){
            Object[][] matrix = new Object[fetchedList.size()][];
            int i= 0;
            for (Container cp : fetchedList) {
                matrix[i++] = new Object[]{cp.getId(), cp.getLocatie().getId(), cp.getType()};
            }
            return matrix;
        }
        return null;
    }
}

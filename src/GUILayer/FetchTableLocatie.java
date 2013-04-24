/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILayer;

import java.util.List;
import Entity.Locatie;

/**
 *
 * @author Bart
 */
public class FetchTableLocatie implements IFetchTable<Locatie> {
    
    @Override
    public Object[][] Fetch(List<Locatie> fetchedList){
        if(!fetchedList.isEmpty()){
            Object[][] matrix = new Object[fetchedList.size()][];
            int i= 0;
            for (Locatie cp : fetchedList) {
                matrix[i++] = new Object[]{cp.getId(), cp.getContainers(), cp.getWerkpersonen()};
            }
            return matrix;
        }
        return null;
    }
}

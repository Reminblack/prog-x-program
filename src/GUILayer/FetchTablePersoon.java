/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILayer;

import java.util.List;
import Entity.Persoon;

/**
 *
 * @author Bart
 */
public class FetchTablePersoon implements IFetchTable<Persoon> {
    
    @Override
    public Object[][] Fetch(List<Persoon> fetchedList){
        if(!fetchedList.isEmpty()){
            Object[][] matrix = new Object[fetchedList.size()][];
            int i= 0;
            for (Persoon cp : fetchedList) {
                matrix[i++] = new Object[]{cp.getId(), cp.getMemberName()};
            }
            return matrix;
        }
        return null;
    }
}

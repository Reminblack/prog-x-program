/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILayer;

import java.util.List;
import Entity.Product;

/**
 *
 * @author Bart
 */
public class FetchTableProduct implements IFetchTable<Product> {
    
    @Override
    public Object[][] Fetch(List<Product> fetchedList){
        if(!fetchedList.isEmpty()){
            Object[][] matrix = new Object[fetchedList.size()][];
            int i= 0;
            for (Product cp : fetchedList) {
                matrix[i++] = new Object[]{cp.getId(), cp.getMerk(), cp.getNaam(), cp.getPrijs(), cp.getContainer().getId()};
            }
            return matrix;
        }
        return null;
    }
}

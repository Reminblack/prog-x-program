/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILayer;

import java.util.List;
import Entity.ProductHistory;

/**
 *
 * @author Bart
 */
public class FetchTableProductHistory implements IFetchTable<ProductHistory> {
    
    @Override
    public Object[][] Fetch(List<ProductHistory> fetchedList){
        if(!fetchedList.isEmpty()){
            Object[][] matrix = new Object[fetchedList.size()][];
            int i= 0;
            for (ProductHistory cp : fetchedList) {
                matrix[i++] = new Object[]{cp.getId(), cp.getAantal(), cp.getDateBegin(), cp.getDateEind(), cp.getPrijs(), cp.getProductId().getId()};
            }
            return matrix;
        }
        return null;
    }
}

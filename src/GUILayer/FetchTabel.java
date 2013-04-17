package GUILayer;

import java.util.ArrayList;
import java.util.List;
import supermarktmanager.Container;
import supermarktmanager.Persoon;
import supermarktmanager.Product;
import supermarktmanager.ProductGeschiedenis;

public class FetchTabel {

    public Object[][] Fetch(List<Object> tabellen) {
        List convertlist = tabellen;
        Object tabel = tabellen.get(0);
        
        if (tabel instanceof Persoon) {
            
        } else if (tabel instanceof Container) {
            
        } else if (tabel instanceof ProductGeschiedenis) {
            
        } else if (tabel instanceof Product) {
            List<Product> producten = (List<Product>) convertlist;
            List<Object> producttabel = new ArrayList<Object>();
            for (Product cp : producten) {
                producttabel.add(new Object[]{cp.getId(), cp.getMerk(), cp.getNaam(), cp.getPrijs(), cp.getRek()});
            }
            Object[][] matrix = new Object[producttabel.size()][];
            matrix = producttabel.toArray(matrix);
            return matrix;
        }
        return null;

    }
}

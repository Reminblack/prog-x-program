package GUILayer;

import java.util.ArrayList;
import java.util.List;
import supermarktmanager.Container;
import supermarktmanager.Persoon;
import supermarktmanager.Product;
import supermarktmanager.ProductHistory;

public class FetchTabel {

    public Object[][] Fetch(List<Object> tabellen) {
        List convertlist = tabellen;
        Object tabel = tabellen.get(0);

        if (tabel instanceof Persoon) {
            List<Persoon> personen = (List<Persoon>) convertlist;
            List<Object> containertabel = new ArrayList<Object>();
            for (Persoon cp : personen) {
                containertabel.add(new Object[]{cp.getId(), cp.getMemberName()});
            }
            Object[][] matrix = new Object[containertabel.size()][];
            matrix = containertabel.toArray(matrix);
            return matrix;
        } else if (tabel instanceof Container) {
            List<Container> containers = (List<Container>) convertlist;
            List<Object> containertabel = new ArrayList<Object>();
            for (Container cp : containers) {
                containertabel.add(new Object[]{cp.getId(), cp.getLocatie().getId(), cp.getType()});
            }
            Object[][] matrix = new Object[containertabel.size()][];
            matrix = containertabel.toArray(matrix);
            return matrix;
        } else if (tabel instanceof ProductHistory) {
            List<ProductHistory> history = (List<ProductHistory>) convertlist;
            List<Object> historytabel = new ArrayList<Object>();
            for (ProductHistory cp : history) {
                historytabel.add(new Object[]{cp.getId(), cp.getAantal(), cp.getDateBegin(), cp.getDateEind(), cp.getPrijs(), cp.getProductId().getId()});
            }
            Object[][] matrix = new Object[historytabel.size()][];
            matrix = historytabel.toArray(matrix);
            return matrix;
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

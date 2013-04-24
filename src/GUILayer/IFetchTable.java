/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILayer;

import java.util.List;

/**
 *
 * @author Bart
 */
public interface IFetchTable<T> {
    public Object[][] Fetch(List<T> fetchedList);
}

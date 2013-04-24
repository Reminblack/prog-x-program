/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DaoLayer.Dao;
import java.util.ArrayList;
import java.util.List;
import Entity.Kassiere;
import Entity.Persoon;

/**
 *
 * @author Bart
 */
public class KassiereService extends PersoonService{
    private boolean isSet = false;
    public void setService(Dao PersoonDao){
        if(!isSet){
            super.setDao(PersoonDao);
            isSet = true;
        }
    }
    
    public void addNewKassiere(Kassiere newKassiere){
        super.addPersoon(newKassiere);
    }
    
    public void updateKassiere(Kassiere updatedKassiere){
        super.updatePersoon(updatedKassiere);
    }
    
    public Kassiere getKassiereById(Long kassiere_id)
    {
        Persoon foundEmployee = super.getPersoonById(kassiere_id);
        if(foundEmployee instanceof Kassiere){
            return (Kassiere)foundEmployee;
        } else {
            System.out.println("This is not a Kassiere.");
        }
        return null;
    }
    
    public List<Kassiere> getAllKassieres(){
        List<Kassiere> foundKassieres = new ArrayList();
        for(Persoon currentEmployee : super.getAllPersoons()){
            if(currentEmployee instanceof Kassiere){
                foundKassieres.add((Kassiere)currentEmployee);
            }
        }
        return foundKassieres;
    }
    
    public void deleteAKassiere(Kassiere kassiere){
        super.deleteAPersoon(kassiere);
    }
}

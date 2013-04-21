/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.KassiereDao;
import java.util.List;
import supermarktmanager.Kassiere;

/**
 *
 * @author Bart
 */
public class KassiereService {
    private KassiereDao kassiereDao;
    
    public void setKassiereDAO(KassiereDao kassiereDao){
        this.kassiereDao = kassiereDao;
    }
    
    public void addNewKassiere(Kassiere newKassiere){
        kassiereDao.create(newKassiere);
    }
    
    public void updateKassiere(Kassiere updatedKassiere){
        kassiereDao.update(updatedKassiere);
    }
    
    public Kassiere getKassiereById(Long kassiere_id)
    {
        return kassiereDao.retrieve(kassiere_id);
    }
    
    public List<Kassiere> getAllKassieres()
    {
        return kassiereDao.retrieveAll();
    }
    
    public void deleteAKassiere(Kassiere kassiere){
        kassiereDao.remove(kassiere);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.*;
import java.util.HashMap;
import org.hibernate.Session;
import supermarktmanager.newHibernateUtil;
/**
 *
 * @author Bart
 */
public class StaticContainer {
    
   private static StaticContainer instance = null;
   private static HashMap<String, Object> services = new HashMap();
   private Session hibernateSession;
   
   protected StaticContainer(){
       hibernateSession = newHibernateUtil.getSessionFactory().getCurrentSession();
       
       VakkenVullerService vvs = new VakkenVullerService();
       vvs.setVakkenVullerDao(new VakkenVullerDao());
       services.put("VakkenVullerService", vvs);
       
       LocatieService ls = new LocatieService();
       ls.setLocatieDao(new LocatieDao());
       services.put("LocatieService", ls);
       
       BakkerService bs = new BakkerService();
       bs.setBakkerDAO(new BakkerDao());
       services.put("BakkerService", bs);
       
       KassiereService ks = new KassiereService();
       ks.setKassiereDAO(new KassiereDao());
       services.put("KassiereService", ks);
       
       SlagerService ss = new SlagerService();
       ss.setSlagerDAO(new SlagerDao());
       services.put("SlagerService", ss);
       
       ///new LocatieService
       ///new PersoonService
       ///addDao LocatieService
       ///addDao PersoonService
       // put
       // put
   }
   
   public static StaticContainer getInstance() {
      if(instance == null) {
         instance = new StaticContainer();
      }
      return instance;
   }
   
   public static Object getService(String service_id){
       return services.get(service_id);
   }
   
   public static Session getSession(){
       if(!instance.hibernateSession.isOpen()){
           instance.hibernateSession = newHibernateUtil.getSessionFactory().getCurrentSession();
       }
       return instance.hibernateSession;
       
   }
   
}

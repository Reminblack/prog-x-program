/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

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
   private static HashMap<String, Object> services = new HashMap<>();
   private Session hibernateSession;
   
   protected StaticContainer(){
       hibernateSession = newHibernateUtil.getSessionFactory().getCurrentSession();
       
       VakkenVullerService vvs = new VakkenVullerService();
       vvs.setVakkenVullerDao(new VakkenVullerDao());
       services.put("VakkenVullerService", vvs);
       
       LocatieService ls = new LocatieService();
       ls.setLocatieDao(new LocatieDao());
       services.put("LocatieService", ls);
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

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
   private HashMap<String, Object> services;
   private Session hibernateSession;
   private Dao BakkerService, ContainerService, KassiereService, LocatieService, ProductService, ProductHistoryService;
   
   protected StaticContainer(){
       hibernateSession = newHibernateUtil.getSessionFactory().getCurrentSession();
   }
   
   public static StaticContainer getInstance() {
      if(instance == null) {
         instance = new StaticContainer();
      }
      return instance;
   }
   
   public Object getService(String service_id){
       return services.get(service_id);
   }
   
}

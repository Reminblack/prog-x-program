/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DaoLayer.PersoonDao;
import DaoLayer.ContainerDao;
import DaoLayer.LocatieDao;
import DaoLayer.Dao;
import DaoLayer.ProductHistoryDao;
import DaoLayer.ProductDao;
import java.util.HashMap;
import org.hibernate.Session;
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
       Dao persoonDao = new PersoonDao();
       VakkenVullerService vvs = new VakkenVullerService();
       SlagerService ss = new SlagerService();
       BakkerService bs = new BakkerService();
       KassiereService ks = new KassiereService();
       
       vvs.setDao(persoonDao);
       ss.setDao(persoonDao);
       bs.setDao(persoonDao);
       ks.setDao(persoonDao);
       
       services.put("VakkenVullerService", vvs);
       services.put("SlagerService", ss);
       services.put("BakkerService", bs);
       services.put("KassiereService", ks);
       
       LocatieService ls = new LocatieService();
       ls.setLocatieDao(new LocatieDao());
       services.put("LocatieService", ls);
       
       ContainerService cs = new ContainerService();
       cs.setContainerDAO(new ContainerDao());
       services.put("ContainerService", cs);
       
       ProductHistoryService phs = new ProductHistoryService();
       phs.setProductHistoryDAO(new ProductHistoryDao());
       services.put("ProductHistoryService", phs);
       
       ProductService ps = new ProductService();
       ps.setProductDao(new ProductDao());
       ps.setProductServices(phs, cs);
       services.put("ProductService", ps);
       
       
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

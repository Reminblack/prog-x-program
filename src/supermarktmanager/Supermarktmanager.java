package supermarktmanager;

import DAOClasses.DAOContainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Supermarktmanager {

    private DAOClasses.DAOContainer container;
    public static void main(String[] args) {
        //lol do nothing
    }
    
    public DAOContainer getSession()
    {
        if(container != null)
        {
            return container;
        }
        else    
        {
            container = new DAOContainer();
            return container;
        }    
    }
}

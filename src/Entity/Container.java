package Entity;

import ServiceLayer.StaticContainer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Container {
    @OneToMany(mappedBy = "rek")
    private List<Product> products = new ArrayList();
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Locatie locatie;
    private String type;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void addProduct(Product p)
    {
        StaticContainer.getSession().beginTransaction();
        products.add(p);
        StaticContainer.getSession().getTransaction().commit();
    }
    
    public void removeProduct(Product p)
    {
        StaticContainer.getSession().beginTransaction();
        products.remove(p);
        StaticContainer.getSession().getTransaction().commit();
    }
}

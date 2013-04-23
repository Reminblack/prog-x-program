package supermarktmanager;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Container {
    @OneToMany(mappedBy = "rek")
    private List<Product> products;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Locatie locatie;
    @Column(nullable = false)
    private String type;
    
    private String restriction;

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
        products.add(p);
    }
    
    public void removeProduct(Product p)
    {
        products.remove(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }
    
    
}

package supermarktmanager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    String naam;
    String merk;
    int reknr;
    int aantal = 0;
    
    public Product() {}
    
    public Product(String naam) {
        this.naam = naam;
    }
}

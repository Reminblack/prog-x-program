package supermarktmanager;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Temporal;

//djfewiofwehofiwehfowe

@Entity
public class ProductHistory implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private int productId;
    
    private int aantal = 0;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateBegin = new Date();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEind;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEind() {
        return dateEind;
    }

    public void setDateEind(Date dateEind) {
        this.dateEind = dateEind;
    }
    
    
}

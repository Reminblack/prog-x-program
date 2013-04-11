package supermarktmanager;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class ProductGeschiedenis{

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Product productId;
    @Column(nullable = false)
    private int aantal = 0;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateBegin;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEind;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

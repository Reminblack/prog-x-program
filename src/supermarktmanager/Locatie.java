package supermarktmanager;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Locatie {
    @Id
    @GeneratedValue
    private Long id;
    
        @ManyToMany
    protected List<Persoon> werkpersonen = new ArrayList<Persoon>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

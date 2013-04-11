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
    private List<Persoon> personeel = new ArrayList<Persoon>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Persoon> getPersoneel() {
        return personeel;
    }

    public void setPersoneel(List<Persoon> personeel) {
        this.personeel = personeel;
    }
    
    public void addPersoon (Persoon employee)
    {
        personeel.add(employee);
    }
    
    public void removePersoon(Persoon employee)
    {
        personeel.remove(employee);
    }
}

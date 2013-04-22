package supermarktmanager;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Locatie {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private List<Container> containers = new ArrayList<Container>();
    @ManyToMany
    private List<Persoon> werknemers = new ArrayList<Persoon>();

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public void addContainer(Container c)
    {
        containers.add(c);
    }
    
    public void removeContainer(Container c){
        containers.remove(c);
    }
    
    public List<Persoon> getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(List<Persoon> werknemers) {
        this.werknemers = werknemers;
    }

    public void addWerknemer(Persoon p)
    {
        werknemers.add(p);
    }
    
    public void removeWerknemer(Persoon p)
    {
        werknemers.remove(p);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

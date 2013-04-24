package Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Locatie {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private List<Persoon> werkPersonen = new ArrayList<Persoon>();
    @OneToMany
    private List<Container> containers = new ArrayList<Container>();

    public List<Persoon> getWerkpersonen() {
        return werkPersonen;
    }

    public void setWerkpersonen(List<Persoon> werkpersonen) {
        this.werkPersonen = werkpersonen;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addContainer(Container c) {
        containers.add(c);
    }

    public void removeContainer(Container c) {
        containers.remove(c);
    }

    public void addWerknemer(Persoon p) {
        werkPersonen.add(p);
    }

    public void removeWerknemer(Persoon p) {
        werkPersonen.remove(p);
    }
}

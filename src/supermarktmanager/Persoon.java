package supermarktmanager;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Column;

@Entity
public abstract class Persoon {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String Name;
    
    @ManyToMany
    private List<Locatie> werkplekken = new ArrayList<Locatie>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return Name;
    }

    public void setMemberName(String memberName) {
        this.Name = memberName;
    }
    
    public void addLocation(Locatie newLocation){
        werkplekken.add(newLocation);
    }
    
    public void removeLocation(Locatie removeLocation){
        werkplekken.remove(removeLocation);
    }
    
    public List<Locatie> getLocations(){
        return werkplekken;
    }
}
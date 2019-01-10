package irix.location.structure;

import irix.location.service.LocationAttributesImp;

public class LocationAttributes extends Location implements LocationAttributesImp {
    
    private Integer id;

    public LocationAttributes() {
    }

    public LocationAttributes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id ;
    }
    
}

package irix.measurement.structure;

import irix.measurement.service.ValueImp;


public class Value extends Measurement implements ValueImp /*implements Comparable<Value>*/ {
    
    private Double dosePhantom;
    private ValueAttributes valueAttributes;

    public Value() {
    }

    public Value(Double dosePhantom, ValueAttributes valueAttributes) {
        this.dosePhantom = dosePhantom;
        this.valueAttributes = valueAttributes;
    }

    public ValueAttributes getValueAttributes() {
        return valueAttributes;
    }

    public void setValueAttributes(ValueAttributes valueAttributes) {
        this.valueAttributes = valueAttributes;
    }

    public Double getDosePhantom() {
        return dosePhantom;
    }

    public void setDosePhantom(Double dosePhantom) {
        this.dosePhantom = dosePhantom;
    }
        
    @Override
    public String toString() {
        return "dose=" + dosePhantom + ", "
                + "valueAttributes=" + valueAttributes;
    }
    
    public int hashCode() {
        final int prime = 53;
        int hash = 3;
        hash = prime * hash + ((dosePhantom == null) ? 0 : dosePhantom.hashCode());
        return hash;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof Value)) return false;
        return this.dosePhantom == ((Value)obj).getDosePhantom();
    }

    public int compareTo(Value o) {
        return dosePhantom.compareTo(o.getDosePhantom());
    }
    
}

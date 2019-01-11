package irix.measurement.structure;

import irix.measurement.service.ValueImp;


public class MonValue extends MonMeasurement implements ValueImp /*implements Comparable<Value>*/ {
    
    private Double dosePhantom;
    private ValueAttributes valueAttributes;

    public MonValue() {
    }

    public MonValue(Double dosePhantom, ValueAttributes valueAttributes) {
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
        if (!(obj instanceof MonValue)) return false;
        return this.dosePhantom == ((MonValue)obj).getDosePhantom();
    }

    public int compareTo(MonValue o) {
        return dosePhantom.compareTo(o.getDosePhantom());
    }
    
}

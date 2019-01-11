package irix.measurement.structure;

import irix.measurement.service.MeasuringPeriodImp;


public class MonMeasuringPeriod extends MonDoseRate implements MeasuringPeriodImp {
    
    String monStartTime;
    String monEndTime;

    public MonMeasuringPeriod() {
    }

    public MonMeasuringPeriod(String monStartTime, String monEndTime) {
        this.monStartTime = monStartTime;
        this.monEndTime = monEndTime;
    }
    
    public String getMonStartTime() {
        return monStartTime;
    }

    public void setMonStartTime(String monStartTime) {
        this.monStartTime = monStartTime;
    }

    public String getMonEndTime() {
        return monEndTime;
    }

    public void setMonEndTime(String monEndTime) {
        this.monEndTime = monEndTime;
    }

    @Override
    public String toString() {
        return "monStartTime=" + monStartTime + ","
                + "monEndTime=" + monEndTime;
    }    
    
}

package irix.measurement.structure;

import irix.measurement.service.MeasuringPeriodImp;


public class MeasuringPeriod extends DoseRate implements MeasuringPeriodImp {
    
    String startTime;
    String endTime;

    public MeasuringPeriod() {
    }

    public MeasuringPeriod(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "startTime=" + startTime + ","
                + "endTime=" + endTime;
    }    
    
}

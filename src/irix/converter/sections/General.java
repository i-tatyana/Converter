package irix.converter.sections;

import irix.identification.service.IdentificationSectionalImp;
import irix.identification.service.IdentificationsImp;
import irix.identification.service.OrganizationContactInfoImp;
import irix.identification.service.PersonContactInfoImp;
import irix.identification.structure.BaseOrganizationContactInfo;
import irix.identification.structure.BasePersonContactInfo;
import irix.identification.structure.IdIdentifications;
import irix.location.service.GeographicCoordinatesImp;
import irix.location.service.HeightAttributesImp;
import irix.location.service.HeightImp;
import irix.location.service.LocationAttributesImp;
import irix.location.service.LocationImp;
import irix.location.service.LocationsSectionalImp;
import irix.location.structure.LocGeographicCoordinates;
import irix.location.structure.LocHeight;
import irix.location.structure.HeightAttributes;
import irix.location.structure.LocationAttributes;
import irix.measurement.service.DoseRateImp;
import irix.measurement.service.LocationMeasurementAttributesImp;
import irix.measurement.service.LocationMeasurementImp;
import irix.measurement.service.MeasurementImp;
import irix.measurement.service.MeasurementsImp;
import irix.measurement.service.MeasuringPeriodImp;
import irix.measurement.service.ValueAttributesImp;
import irix.measurement.service.ValueImp;
import irix.measurement.structure.LocLocationMeasurement;
import irix.measurement.structure.LocationMeasurementAttributes;
import irix.measurement.structure.MonMeasurement;
import irix.measurement.structure.MonMeasurements;
import irix.measurement.structure.MonMeasuringPeriod;
import irix.measurement.structure.MonValue;
import irix.measurement.structure.ValueAttributes;
import irix.location.structure.LocLocation;
import irix.measurement.service.MeasurementsSectionalAttributesImp;
import irix.measurement.service.MeasurementsSectionalImp;
import irix.measurement.structure.MeasurementsSectionalAttributes;
import irix.measurement.structure.MonDoseRate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class General implements LocationsSectionalImp, IdentificationSectionalImp, IdentificationsImp, PersonContactInfoImp, OrganizationContactInfoImp, MeasurementsSectionalImp, MeasurementsSectionalAttributesImp, DoseRateImp, MeasuringPeriodImp, MeasurementsImp, MeasurementImp, LocationMeasurementImp, LocationMeasurementAttributesImp,ValueImp, ValueAttributesImp, LocationImp, LocationAttributesImp, GeographicCoordinatesImp, HeightImp, HeightAttributesImp {
    
    private IdIdentificationSectional idIdentificationSectional;    
    private MonMeasurementsSectional monMeasurementsSectional;
    private LocLocationsSectional locLocationsSectional;
    
    private List<MonMeasurementsSectional>measurementsList = new ArrayList<MonMeasurementsSectional>();
    private List<LocLocationsSectional>locationsList = new ArrayList<LocLocationsSectional>();
    
//    private Map<Integer,MonMeasurementsSectional>measurementsMap = new HashMap<Integer,MonMeasurementsSectional>();
//    private Map<Integer,LocLocationsSectional>locationsMap = new HashMap<Integer,LocLocationsSectional>();

    public General() {
    }
    
    public General(IdIdentificationSectional idIdentificationSectional, List<MonMeasurementsSectional>measurementsList, List<LocLocationsSectional>locationsList) {
        this.idIdentificationSectional = idIdentificationSectional;
        this.measurementsList = measurementsList;
        this.locationsList = locationsList;
    }

    public General(MonMeasurementsSectional monMeasurementsSectional, LocLocationsSectional locLocationsSectional) {
        this.monMeasurementsSectional = monMeasurementsSectional;
        this.locLocationsSectional = locLocationsSectional;
    }

    public IdIdentificationSectional getIdIdentificationSectional() {
        return idIdentificationSectional;
    }

    public void setIdIdentificationSectional(IdIdentificationSectional idIdentificationSectional) {
        this.idIdentificationSectional = idIdentificationSectional;
    }

    public MonMeasurementsSectional getMonMeasurementsSectional() {
        return monMeasurementsSectional;
    }

    public void setMonMeasurementsSectional(MonMeasurementsSectional monMeasurementsSectional) {
        this.monMeasurementsSectional = monMeasurementsSectional;
    }

    public LocLocationsSectional getLocLocationsSectional() {
        return locLocationsSectional;
    }

    public void setLocLocationsSectional(LocLocationsSectional locLocationsSectional) {
        this.locLocationsSectional = locLocationsSectional;
    }

    public List<MonMeasurementsSectional> getMeasurementsList() {
        return measurementsList;
    }

    public void setMeasurementsList(List<MonMeasurementsSectional> measurementsList) {
        this.measurementsList = measurementsList;
    }

    public List<LocLocationsSectional> getLocationsList() {
        return locationsList;
    }

    public void setLocationsList(List<LocLocationsSectional> locationsList) {
        this.locationsList = locationsList;
    }

//    public Map<Integer, MonMeasurementsSectional> getMeasurementsMap() {
//        return measurementsMap;
//    }
//
//    public void setMeasurementsMap(Map<Integer, MonMeasurementsSectional> measurementsMap) {
//        this.measurementsMap = measurementsMap;
//    }
//
//    public Map<Integer, LocLocationsSectional> getLocationsMap() {
//        return locationsMap;
//    }
//
//    public void setLocationsMap(Map<Integer, LocLocationsSectional> locationsMap) {
//        this.locationsMap = locationsMap;
//    }
    
    @Override
    public BasePersonContactInfo getPerson() {
        return this.getIdIdentificationSectional().getIdIdentifications().getPerson();
    }

    @Override
    public BaseOrganizationContactInfo getOrganization() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization();
    }

    @Override
    public String getBasePersonName() {
        return this.getIdIdentificationSectional().getIdIdentifications().getPerson().getBasePersonName();
    }

    @Override
    public String getBasePersonOrganisationID() {
        return this.getIdIdentificationSectional().getIdIdentifications().getPerson().getBasePersonOrganisationID();
    }

    @Override
    public String getBasePersonEmailAddress() {
        return this.getIdIdentificationSectional().getIdIdentifications().getPerson().getBasePersonEmailAddress();
    }

    @Override
    public String getBaseName() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getBaseName();
    }

    @Override
    public String getBaseOrganisationID() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getBaseOrganisationID();
    }

    @Override
    public String getBaseCountry() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getBaseCountry();
    }

    @Override
    public String getBasePhoneNumber() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getBasePhoneNumber();
    }

    @Override
    public String getBaseFaxNumber() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getBaseFaxNumber();
    }

    @Override
    public String getBaseEmailAddress() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getBaseEmailAddress();
    }

    @Override
    public String getBaseDescription() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getBaseDescription();
    }

    @Override
    public String getLocName() {
        return this.getLocLocationsSectional().getLocLocation().getLocName();
    }

    @Override
    public LocGeographicCoordinates getLocGeographicCoordinates() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates();
    }

    @Override
    public LocationAttributes getLocationAttributes() {
        return this.getLocLocationsSectional().getLocLocation().getLocationAttributes();
    }

    @Override
    public Double getLocLatitude() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates().getLocLatitude();
    }

    @Override
    public Double getLocLongitude() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates().getLocLongitude();
    }

    @Override
    public LocHeight getLocHeight() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates().getLocHeight();
    }

    @Override
    public Integer getAltitudePhantom() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates().getLocHeight().getAltitudePhantom();
    }

    @Override
    public HeightAttributes getHeightAttributes() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates().getLocHeight().getHeightAttributes();
    }

    @Override
    public String getAbove() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates().getLocHeight().getHeightAttributes().getAbove();
    }

    @Override
    public String getUnit() {
        return this.getLocLocationsSectional().getLocLocation().getLocGeographicCoordinates().getLocHeight().getHeightAttributes().getUnit();
    }    

    @Override
    public Integer getId() {
        return this.getLocLocationsSectional().getLocLocation().getLocationAttributes().getId();
    }

    @Override
    public LocLocation getLocLocation() {
        return this.getLocLocationsSectional().getLocLocation();
    }
    
    @Override
    public String getIdOrganisationReporting() {
        return this.getIdIdentificationSectional().getIdOrganisationReporting();
    }

    @Override
    public String getIdDateAndTimeOfCreation() {
        return this.getIdIdentificationSectional().getIdDateAndTimeOfCreation();
    }

    @Override
    public String getIdReportContext() {
        return this.getIdIdentificationSectional().getIdReportContext();
    }

    @Override
    public String getIdReportUUID() {
        return this.getIdIdentificationSectional().getIdReportUUID();
    }

    @Override
    public String getIdConfidentiality() {
        return this.getIdIdentificationSectional().getIdConfidentiality();
    }

    @Override
    public IdIdentifications getIdIdentifications() {
        return this.getIdIdentificationSectional().getIdIdentifications();
    }

    @Override
    public List<BasePersonContactInfo> getPersonList() {
        return this.getIdIdentificationSectional().getIdIdentifications().getPersonList();
    }

    @Override
    public List<BaseOrganizationContactInfo> getOrganizationList() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganizationList();
    }
      
    @Override
    public List<BaseOrganizationContactInfo> getOrganizationContactInfoList() {
        return this.getIdIdentificationSectional().getIdIdentifications().getOrganization().getOrganizationContactInfoList();
    }

    @Override
    public List<BasePersonContactInfo> getPersonContactInfoList() {
        return this.getIdIdentificationSectional().getIdIdentifications().getPerson().getPersonContactInfoList();
    }

    @Override
    public MonDoseRate getMonDoseRate() {
        return this.getMonMeasurementsSectional().getMonDoseRate();
    }

    @Override
    public MeasurementsSectionalAttributes getMeasurementsSectionalAttributes() {
        return this.getMonMeasurementsSectional().getMeasurementsSectionalAttributes();
    }

    @Override
    public String getValidAt() {
        return this.getMonMeasurementsSectional().getMeasurementsSectionalAttributes().getValidAt();
    }

    @Override
    public String getMonDoseRateType() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonDoseRateType();
    }

    @Override
    public MonMeasuringPeriod getMonMeasuringPeriod() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasuringPeriod();
    }

    @Override
    public MonMeasurements getMonMeasurements() {
        return this.getMonMeasurementsSectional().getMonMeasurements();
    }

    @Override
    public String getMonStartTime() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasuringPeriod().getMonStartTime();
    }

    @Override
    public String getMonEndTime() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasuringPeriod().getMonEndTime();
    }

    @Override
    public MonMeasurement getMonMeasurement() {
        return this.getMonMeasurementsSectional().getMonMeasurements().getMonMeasurement();
    }

    @Override
    public LocLocationMeasurement getLocLocationMeasurement() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getLocLocationMeasurement();
    }

    @Override
    public MonValue getMonValue() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue();
    }

    @Override
    public String getMonValidated() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValidated();
    }

    @Override
    public LocationMeasurementAttributes getLocationMeasurementAttributes() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getLocLocationMeasurement().getLocationMeasurementAttributes();
    }

    @Override
    public String getRef() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getLocLocationMeasurement().getLocationMeasurementAttributes().getRef();
    }

    @Override
    public Double getDosePhantom() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue().getDosePhantom();
    }

    @Override
    public ValueAttributes getValueAttributes() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue().getValueAttributes();
    }

    @Override
    public String toString() {
        return "General{" + "idIdentificationSectional=" + idIdentificationSectional + ", monMeasurementsSectional=" + monMeasurementsSectional + ", locLocationsSectional=" + locLocationsSectional + ", measurementsList=" + measurementsList + ", locationsList=" + locationsList + '}';
    }

    @Override
    public String getValueUnit() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue().getValueAttributes().getValueUnit();
    }
                
}

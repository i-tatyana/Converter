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
import irix.measurement.service.MeasurementsSectionalImp;
import irix.measurement.structure.MeasurementsSectionalAttributes;
import irix.measurement.structure.MonDoseRate;
import irix.report.structure.IdIdentificationSectional;
import irix.report.structure.LocLocationsSectional;
import irix.report.structure.MonMeasurementsSectional;


public class Sectional implements LocationsSectionalImp, MeasurementsSectionalImp, IdentificationSectionalImp, IdentificationsImp, PersonContactInfoImp, OrganizationContactInfoImp, LocationImp, LocationAttributesImp, GeographicCoordinatesImp, HeightImp, HeightAttributesImp, DoseRateImp, MeasuringPeriodImp, MeasurementsImp, MeasurementImp, LocationMeasurementImp, LocationMeasurementAttributesImp, ValueImp, ValueAttributesImp {
    
    IdIdentificationSectional idIdentificationSectional;    
    MonMeasurementsSectional monMeasurementsSectional;
    LocLocationsSectional locLocationsSectional;

    public Sectional() {
    }

    public Sectional(IdIdentificationSectional idIdentificationSectional, MonMeasurementsSectional monMeasurementsSectional, LocLocationsSectional locLocationsSectional) {
        this.idIdentificationSectional = idIdentificationSectional;
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
    public String getMonDoseRateType() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonDoseRateType();
    }

    @Override
    public MonMeasuringPeriod getMonMeasuringPeriod() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasuringPeriod();
    }

    @Override
    public MonMeasurements getMonMeasurements() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements();
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
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement();
    }

    @Override
    public LocLocationMeasurement getLocLocationMeasurement() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().getLocLocationMeasurement();
    }

    @Override
    public MonValue getMonValue() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().getMonValue();
    }

    @Override
    public String getMonValidated() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().getMonValidated();
    }
    
    @Override
    public LocationMeasurementAttributes getLocationMeasurementAttributes() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().getLocLocationMeasurement().getLocationMeasurementAttributes();
    }

    @Override
    public String getRef() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().getLocLocationMeasurement().getLocationMeasurementAttributes().getRef();
    }

    @Override
    public Double getDosePhantom() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().getMonValue().getDosePhantom();
    }
    
    public String getValidAt() {
        return this.getMonMeasurementsSectional().getMeasurementsSectionalAttributes().getValidAt();
    }

    @Override
    public ValueAttributes getValueAttributes() {
        return this.getMonMeasurementsSectional().getMonDoseRate().getMonMeasurements().getMonMeasurement().getMonValue().getValueAttributes();
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
    public String toString() {
        return "idIdentificationSectional=" + idIdentificationSectional + ", "
                + "monMeasurementsSectional=" + monMeasurementsSectional + ", "
                + "locLocationsSectional=" + locLocationsSectional;
    }

    @Override
    public LocLocation getLocLocation() {
        return this.getLocLocationsSectional().getLocLocation();
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
                    
}

package irix.section.identifier;

import irix.converter.main.IdentificationSectionalImp;
import irix.converter.main.IdentificationsImp;
import irix.converter.main.OrganizationContactDetailsImp;
import irix.converter.main.PersonContactDetailsImp;
import irix.convertor.sections.IdentificationSectional;
import irix.convertor.sections.LocationsSectional;
import irix.convertor.sections.MeasurementsSectional;
import irix.identification.structure.OrganizationContactDetails;
import irix.identification.structure.PersonContactDetails;
import irix.location.service.GeographicCoordinatesImp;
import irix.location.service.HeightAttributesImp;
import irix.location.service.HeightImp;
import irix.location.service.LocationAttributesImp;
import irix.location.service.LocationImp;
import irix.location.structure.GeographicCoordinates;
import irix.location.structure.Height;
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
import irix.measurement.structure.LocationMeasurement;
import irix.measurement.structure.LocationMeasurementAttributes;
import irix.measurement.structure.Measurement;
import irix.measurement.structure.Measurements;
import irix.measurement.structure.MeasuringPeriod;
import irix.measurement.structure.Value;
import irix.measurement.structure.ValueAttributes;


public class Sectional implements IdentificationSectionalImp, IdentificationsImp, PersonContactDetailsImp, OrganizationContactDetailsImp, LocationImp, LocationAttributesImp, GeographicCoordinatesImp, HeightImp, HeightAttributesImp, DoseRateImp, MeasuringPeriodImp, MeasurementsImp, MeasurementImp, LocationMeasurementImp, LocationMeasurementAttributesImp, ValueImp, ValueAttributesImp {
    
    IdentificationSectional identificationSectional;    
    MeasurementsSectional measurementsSectional;
    LocationsSectional locationsSectional;

    public Sectional() {
    }

    public Sectional(IdentificationSectional identificationSectional, MeasurementsSectional measurementsSectional, LocationsSectional locationsSectional) {
        this.identificationSectional = identificationSectional;
        this.measurementsSectional = measurementsSectional;
        this.locationsSectional = locationsSectional;
    }

    public IdentificationSectional getIdentificationSectional() {
        return identificationSectional;
    }

    public void setIdentificationSectional(IdentificationSectional identificationSectional) {
        this.identificationSectional = identificationSectional;
    }

    public MeasurementsSectional getMeasurementsSectional() {
        return measurementsSectional;
    }

    public void setMeasurementsSectional(MeasurementsSectional measurementsSectional) {
        this.measurementsSectional = measurementsSectional;
    }

    public LocationsSectional getLocationsSectional() {
        return locationsSectional;
    }

    public void setLocationsSectional(LocationsSectional locationsSectional) {
        this.locationsSectional = locationsSectional;
    }
    
    @Override
    public String getOrganisationReporting() {
        return this.getIdentificationSectional().getReportDetails().getOrganisationReporting();
    }

    @Override
    public String getDateAndTimeOfCreation() {
        return this.getIdentificationSectional().getReportDetails().getDateAndTimeOfCreation();
    }

    @Override
    public String getReportContext() {
        return this.getIdentificationSectional().getReportDetails().getReportContext();
    }

    @Override
    public String getReportUUID() {
        return this.getIdentificationSectional().getReportDetails().getReportUUID();
    }

    @Override
    public String getConfidentiality() {
        return this.getIdentificationSectional().getReportDetails().getConfidentiality();
    }

    @Override
    public PersonContactDetails getPerson() {
        return this.getIdentificationSectional().getIdentifications().getPerson();
    }

    @Override
    public OrganizationContactDetails getOrganization() {
        return this.getIdentificationSectional().getIdentifications().getOrganization();
    }

    @Override
    public String getPersonName() {
        return this.getIdentificationSectional().getIdentifications().getPerson().getPersonName();
    }

    @Override
    public String getPersonOrganisationID() {
        return this.getIdentificationSectional().getIdentifications().getPerson().getPersonOrganisationID();
    }

    @Override
    public String getPersonEmailAddress() {
        return this.getIdentificationSectional().getIdentifications().getPerson().getPersonEmailAddress();
    }

    @Override
    public String getName() {
        return this.getIdentificationSectional().getIdentifications().getOrganization().getName();
    }

    @Override
    public String getOrganisationID() {
        return this.getIdentificationSectional().getIdentifications().getOrganization().getOrganisationID();
    }

    @Override
    public String getCountry() {
        return this.getIdentificationSectional().getIdentifications().getOrganization().getCountry();
    }

    @Override
    public String getPhoneNumber() {
        return this.getIdentificationSectional().getIdentifications().getOrganization().getPhoneNumber();
    }

    @Override
    public String getFaxNumber() {
        return this.getIdentificationSectional().getIdentifications().getOrganization().getFaxNumber();
    }

    @Override
    public String getEmailAddress() {
        return this.getIdentificationSectional().getIdentifications().getOrganization().getEmailAddress();
    }

    @Override
    public String getDescription() {
        return this.getIdentificationSectional().getIdentifications().getOrganization().getDescription();
    }

    @Override
    public String getDoseRateType() {
        return this.getMeasurementsSectional().getDoseRate().getDoseRateType();
    }

    @Override
    public MeasuringPeriod getMeasuringPeriod() {
        return this.getMeasurementsSectional().getDoseRate().getMeasuringPeriod();
    }

    @Override
    public Measurements getMeasurements() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements();
    }

    @Override
    public String getStartTime() {
        return this.getMeasurementsSectional().getDoseRate().getMeasuringPeriod().getStartTime();
    }

    @Override
    public String getEndTime() {
        return this.getMeasurementsSectional().getDoseRate().getMeasuringPeriod().getEndTime();
    }

    @Override
    public Measurement getMeasurement() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement();
    }

    @Override
    public LocationMeasurement getLocationMeasurement() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement();
    }

    @Override
    public Value getValue() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getValue();
    }

    @Override
    public String getValidated() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getValidated();
    }

    @Override
    public LocationMeasurementAttributes getLocationMeasurementAttributes() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement().getLocationMeasurementAttributes();
    }

    @Override
    public String getRef() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement().getLocationMeasurementAttributes().getRef();
    }

    @Override
    public Double getDosePhantom() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getValue().getDosePhantom();
    }
    
    public String getValidAt() {
        return this.getMeasurementsSectional().getMeasurementsSectionalAttributes().getValidAt();
    }

    @Override
    public ValueAttributes getValueAttributes() {
        return this.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getValue().getValueAttributes();
    }

    public Object getDoseRate() {
        return this.getMeasurementsSectional().getDoseRate();
    }

    @Override
    public String getLocationName() {
        return this.getLocationsSectional().getLocation().getLocationName();
    }

    @Override
    public GeographicCoordinates getGeographicCoordinates() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates();
    }

    @Override
    public LocationAttributes getLocationAttributes() {
        return this.getLocationsSectional().getLocation().getLocationAttributes();
    }

    @Override
    public Double getLatitude() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates().getLatitude();
    }

    @Override
    public Double getLongitude() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates().getLongitude();
    }

    @Override
    public Height getHeight() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates().getHeight();
    }

    @Override
    public Integer getAltitudePhantom() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates().getHeight().getAltitudePhantom();
    }

    @Override
    public HeightAttributes getHeightAttributes() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates().getHeight().getHeightAttributes();
    }

    @Override
    public String getAbove() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates().getHeight().getHeightAttributes().getAbove();
    }

    @Override
    public String getUnit() {
        return this.getLocationsSectional().getLocation().getGeographicCoordinates().getHeight().getHeightAttributes().getUnit();
    }    

    @Override
    public Integer getId() {
        return this.getLocationsSectional().getLocation().getLocationAttributes().getId();
    }
    
    @Override
    public String toString() {
        return "identificationSectional=" + identificationSectional + ", "
                + "measurementsSectional=" + measurementsSectional + ", "
                + "locationsSectional=" + locationsSectional;
    }
                
}

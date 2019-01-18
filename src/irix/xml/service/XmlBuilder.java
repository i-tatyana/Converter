package irix.xml.service;

import irix.converter.sections.General;
import irix.converter.sections.LocLocationsSectional;
import irix.converter.sections.MonMeasurementsSectional;
import irix.identification.structure.BaseOrganizationContactInfo;
import irix.identification.structure.BasePersonContactInfo;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XmlBuilder {
    
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder; 
    Document doc;
    Element rootElement;   
    Element identificationElement;
    Element measurementsElement;
    Element locationsElement;
    
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = null;
    
    private boolean identificationFlag = false;
    private boolean measurementFlag = false;
    private boolean locationFlag = false;
    
    public XmlBuilder(String reportName) {
        try {
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument(); 
            doc.setXmlStandalone(true);
            Element rootElement = createRootElement(reportName);
            doc.appendChild(rootElement); 
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XmlBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private Element createRootElement(String rootElementName){
        rootElement = doc.createElement(rootElementName);
        rootElement.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:base", "http://www.iaea.org/2012/IRIX/Format/Base");
        rootElement.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:loc", "http://www.iaea.org/2012/IRIX/Format/Locations");
        rootElement.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:html", "http://www.w3.org/1999/xhtml");
        rootElement.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:id", "http://www.iaea.org/2012/IRIX/Format/Identification");
        rootElement.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:irmis", "http://iec.iaea.org/irmis/2014/irix/format/extensions");
        rootElement.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:mon", "http://www.iaea.org/2012/IRIX/Format/Measurements");
        rootElement.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:irix", "http://www.iaea.org/2012/IRIX/Format");
        return rootElement;
    }
      
    public void createIdentification(General general){
        
        List<BasePersonContactInfo> persons = general.getPersonList();
        List<BaseOrganizationContactInfo> organizations = general.getOrganizationList();
               
        if(!identificationFlag){
            
            identificationElement = doc.createElement("id:Identification"); 
            rootElement.appendChild(identificationElement);

            Element organisationReportingElement = doc.createElement("id:OrganisationReporting");
            organisationReportingElement.appendChild(doc.createTextNode(general.getIdOrganisationReporting()));
            identificationElement.appendChild(organisationReportingElement);

            Element dateAndTimeOfCreationElement = doc.createElement("id:DateAndTimeOfCreation");
            dateAndTimeOfCreationElement.appendChild(doc.createTextNode(general.getIdDateAndTimeOfCreation()));
            identificationElement.appendChild(dateAndTimeOfCreationElement);

            Element reportContextElement = doc.createElement("id:ReportContext");
            reportContextElement.appendChild(doc.createTextNode(general.getIdReportContext()));
            identificationElement.appendChild(reportContextElement);

            Element reportUUIDElement = doc.createElement("id:ReportUUID");
            reportUUIDElement.appendChild(doc.createTextNode(general.getIdReportUUID()));
            identificationElement.appendChild(reportUUIDElement);

            Element confidentialityElement = doc.createElement("id:Confidentiality");
            confidentialityElement.appendChild(doc.createTextNode(general.getIdConfidentiality()));
            identificationElement.appendChild(confidentialityElement);            
            
            identificationFlag = true;
            
        }
        
        Element identificationsElement = doc.createElement("id:Identifications");
        identificationElement.appendChild(identificationsElement);
                        
        for(BasePersonContactInfo person : persons){
                            
            Element personContactInfoElement = doc.createElement("base:PersonContactInfo");
            identificationsElement.appendChild(personContactInfoElement);

            Element personNameElement = doc.createElement("base:Name");
            personNameElement.appendChild(doc.createTextNode(person.getBasePersonName()));
            personContactInfoElement.appendChild(personNameElement);

            Element personOrganisationIDElement = doc.createElement("base:OrganisationID");
            personOrganisationIDElement.appendChild(doc.createTextNode(person.getBasePersonOrganisationID()));
            personContactInfoElement.appendChild(personOrganisationIDElement);

            Element personEmailAddressElement = doc.createElement("base:EmailAddress");
            personEmailAddressElement.appendChild(doc.createTextNode(person.getBasePersonEmailAddress()));
            personContactInfoElement.appendChild(personEmailAddressElement);
                
        }
            
        for(BaseOrganizationContactInfo organization : organizations){
            
            Element organisationContactInfoElement = doc.createElement("base:OrganisationContactInfo");
            identificationsElement.appendChild(organisationContactInfoElement);

            Element organizationNameElement = doc.createElement("base:Name");
            organizationNameElement.appendChild(doc.createTextNode(organization.getBaseName()));
            organisationContactInfoElement.appendChild(organizationNameElement);

            Element organizationOrganisationIDElement = doc.createElement("base:OrganisationID");
            organizationOrganisationIDElement.appendChild(doc.createTextNode(organization.getBaseOrganisationID()));
            organisationContactInfoElement.appendChild(organizationOrganisationIDElement);
                
            Element organizationCountryElement = doc.createElement("base:Country");
            organizationCountryElement.appendChild(doc.createTextNode(organization.getBaseCountry()));
            organisationContactInfoElement.appendChild(organizationCountryElement);
                
            Element organizationPhoneNumberElement = doc.createElement("base:PhoneNumber");
            organizationPhoneNumberElement.appendChild(doc.createTextNode(organization.getBasePhoneNumber()));
            organisationContactInfoElement.appendChild(organizationPhoneNumberElement);
                
            Element organizationFaxNumberElement = doc.createElement("base:FaxNumber");
            organizationFaxNumberElement.appendChild(doc.createTextNode(organization.getBaseFaxNumber()));
            organisationContactInfoElement.appendChild(organizationFaxNumberElement);

            Element organizationEmailAddressElement = doc.createElement("base:EmailAddress");
            organizationEmailAddressElement.appendChild(doc.createTextNode(organization.getBaseEmailAddress()));
            organisationContactInfoElement.appendChild(organizationEmailAddressElement);
                
            Element organizationDescriptionElement = doc.createElement("base:Description");
            organizationDescriptionElement.appendChild(doc.createTextNode(organization.getBaseDescription()));
            organisationContactInfoElement.appendChild(organizationDescriptionElement);
        }
    }
    
    public void createMeasurement(General general){

        List<MonMeasurementsSectional>measurementsList = general.getMeasurementsList();
        
        if(!measurementFlag){
            measurementsElement = doc.createElement("mon:Measurements"); 
            rootElement.appendChild(measurementsElement);

            Attr validAtAttr = doc.createAttribute("ValidAt");
            validAtAttr.setValue(measurementsList.get(0).getValidAt());
            measurementsElement.setAttributeNode(validAtAttr);
            
            measurementFlag = true;
        }
        
        for(MonMeasurementsSectional measurement : measurementsList){
            
            Element doseRateElement = doc.createElement("mon:DoseRate");
            measurementsElement.appendChild(doseRateElement);

            Element doseRateTypeElement = doc.createElement("mon:DoseRateType");
            doseRateTypeElement.appendChild(doc.createTextNode(measurement.getMonDoseRateType()));
            doseRateElement.appendChild(doseRateTypeElement);

            Element measuringPeriodElement = doc.createElement("mon:MeasuringPeriod");
            doseRateElement.appendChild(measuringPeriodElement);

            Element measuringPeriodStartTimeElement = doc.createElement("mon:StartTime");
            measuringPeriodStartTimeElement.appendChild(doc.createTextNode(measurement.getMonStartTime()));
            measuringPeriodElement.appendChild(measuringPeriodStartTimeElement);

            Element measuringPeriodEndTimeElement = doc.createElement("mon:EndTime");
            measuringPeriodEndTimeElement.appendChild(doc.createTextNode(measurement.getMonEndTime()));
            measuringPeriodElement.appendChild(measuringPeriodEndTimeElement); 

            Element subMeasurementsElement = doc.createElement("mon:Measurements");
            doseRateElement.appendChild(subMeasurementsElement);

            Element measurementElement = doc.createElement("mon:Measurement");
            subMeasurementsElement.appendChild(measurementElement);

            Element locationElement = doc.createElement("loc:Location");
            measurementElement.appendChild(locationElement);

            Attr refAttr = doc.createAttribute("ref");
            refAttr.setValue(measurement.getRef());
            locationElement.setAttributeNode(refAttr);

            Element valueElement = doc.createElement("mon:Value");
            valueElement.appendChild(doc.createTextNode(String.valueOf(measurement.getDosePhantom())));
            measurementElement.appendChild(valueElement);

            Attr unitAttr = doc.createAttribute("Unit");
            unitAttr.setValue(measurement.getValueUnit());
            valueElement.setAttributeNode(unitAttr);   

            Element validatedElement = doc.createElement("mon:Validated");
            validatedElement.appendChild(doc.createTextNode(measurement.getMonValidated()));
            measurementElement.appendChild(validatedElement);
            
        }
        
    }
        
    public void createLocationElement(General general){

        List<LocLocationsSectional>locationsList = general.getLocationsList();
               
        if(!locationFlag){
            locationsElement = doc.createElement("loc:Locations");
            rootElement.appendChild(locationsElement);
        }
        
        for(LocLocationsSectional location : locationsList){
            
            Element locationElement = doc.createElement("loc:Location"); 
            locationsElement.appendChild(locationElement);

            Attr locationIdAttr = doc.createAttribute("id");
            locationIdAttr.setValue(String.valueOf(location.getId()));
            locationElement.setAttributeNode(locationIdAttr);

            Element locationNameElement = doc.createElement("loc:Name"); 
            locationNameElement.appendChild(doc.createTextNode(location.getLocName()));
            locationElement.appendChild(locationNameElement);

            Element geographicCoordinatesElement = doc.createElement("loc:GeographicCoordinates"); 
            locationElement.appendChild(geographicCoordinatesElement);

            Element locationLatitudeElement = doc.createElement("loc:Latitude"); 
            locationLatitudeElement.appendChild(doc.createTextNode(String.valueOf(location.getLocLatitude())));
            geographicCoordinatesElement.appendChild(locationLatitudeElement);

            Element locationLongitudeElement = doc.createElement("loc:Longitude"); 
            locationLongitudeElement.appendChild(doc.createTextNode(String.valueOf(location.getLocLongitude())));
            geographicCoordinatesElement.appendChild(locationLongitudeElement);

            Element locationHeightElement = doc.createElement("loc:Height"); 
            locationHeightElement.appendChild(doc.createTextNode(String.valueOf(location.getAltitudePhantom())));
            geographicCoordinatesElement.appendChild(locationHeightElement);

            Attr locationAboveAttr = doc.createAttribute("Above");
            locationAboveAttr.setValue(location.getAbove());
            locationHeightElement.setAttributeNode(locationAboveAttr);

            Attr locationUnitAttr = doc.createAttribute("Unit");
            locationUnitAttr.setValue(location.getUnit());
            locationHeightElement.setAttributeNode(locationUnitAttr);
        
        }       
        
    }         
    
    public void writeContentIntoFile(String outputFileName){
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outputFileName)); 
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XmlBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XmlBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
}

package irix.xml.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
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
    DocumentBuilder docBuilder = null; 
    Document doc = null;
    Element rootElement = null;   
    
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = null;
    
    private static Map<String,Element> irixElements = new HashMap<String,Element>();

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
    
    public void createElement(String tagName){
        Element element = doc.createElement(tagName);
        irixElements.putIfAbsent(tagName, element);
        Element parentElement = getRootElement();
        parentElement.appendChild(element);        
    }
    
    public void createElement(String parentTagName, String childTagName){
        Element childElement = doc.createElement(childTagName);
        irixElements.putIfAbsent(childTagName, childElement);
        Element parentElement = getElementByTagName(parentTagName);
        parentElement.appendChild(childElement);        
    }
        
    public void createElement(String parentTagName, String childTagName, String elementValue){
        Element childElement = doc.createElement(childTagName);
        irixElements.putIfAbsent(childTagName, childElement);
        childElement.appendChild(doc.createTextNode(elementValue));
        Element parentElement = getElementByTagName(parentTagName);
        parentElement.appendChild(childElement);        
    }
    
    public void setElementValue(String parentTagName, String elementValue){
        Element parentElement = getElementByTagName(parentTagName);
        parentElement.appendChild(doc.createTextNode(elementValue));
    }
    
    public void createAttribute(String parentTagName, String attributeName, String attributeValue){
        Element parentElement = getElementByTagName(parentTagName);
        Attr locationAboveAttr = doc.createAttribute(attributeName);
        locationAboveAttr.setValue(attributeValue);        
        parentElement.setAttributeNode(locationAboveAttr);
    }
    
    public Element getElementByTagName(String tagName){
        for (Map.Entry entry: irixElements.entrySet()) {
            String key = (String) entry.getKey();
            Element value = (Element) entry.getValue();
            if(key.equals(tagName)){
                return value;
            }
        }
        return null;
    }

    private Element getRootElement() {
        return rootElement;
    }

    private void setRootElement(Element rootElement) {
        this.rootElement = rootElement;
    }    
    
    public void writeContentIntoFile(String outputFileName){
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outputFileName)); // "C:\\Users\\Tatyana\\Desktop\\file.xml" 
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


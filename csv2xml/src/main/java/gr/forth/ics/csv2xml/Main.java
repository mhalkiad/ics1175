/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.forth.ics.csv2xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author mhalkiad
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, TransformerConfigurationException, TransformerException {
        Reader in = new FileReader(System.getProperty("user.dir") + File.separator + args[0]);
        
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            // root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);
            
            // use the apache commons csv library to parse the csv file
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withDelimiter(';').withFirstRecordAsHeader().parse(in);

            // for each parsed record create a new fish element and add it to the root element
            for (CSVRecord record : records) {
                Element fish = doc.createElement("fish");
		rootElement.appendChild(fish);
                
                // create ScientificName element into fish element
		Element scientificName = doc.createElement("ScientificName");
		scientificName.appendChild(doc.createTextNode(record.get("Scientific Name")));
		fish.appendChild(scientificName);
                
                // create Country element into fish element
		Element country = doc.createElement("Country");
		country.appendChild(doc.createTextNode(record.get("Country")));
		fish.appendChild(country);
                
                // create WaterArea element into fish element
                Element waterArea = doc.createElement("WaterArea");
		waterArea.appendChild(doc.createTextNode(record.get("Water Area")));
		fish.appendChild(waterArea);
                
                // create CommonName element into fish element
                Element commonName = doc.createElement("CommonName");
		commonName.appendChild(doc.createTextNode(record.get("Common Name")));
		fish.appendChild(commonName);
               
                // Write the output_template.xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + File.separator + "output_template.xml"));
                transformer.transform(source, result);
            }
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } 
    }
}

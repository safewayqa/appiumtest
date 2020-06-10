package com.qa.utils;

import java.io.InputStream;
import java.util.HashMap;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestUtils {
public static final long wait=60;


public HashMap<String, String> parseStringXML(InputStream file) throws Exception{
	
	HashMap<String, String> stringmap=new HashMap<String, String>();
	//Get Document Builder
	DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
	DocumentBuilder builder= factory.newDocumentBuilder();
	
	//Build Document
	org.w3c.dom.Document document=builder.parse(file);
	
	//Normalize the XML structure ; its just to import !!
	document.getDocumentElement().normalize();
	
	//Here comes the root node
	Element root=document.getDocumentElement();
	
	//Get all elements
	NodeList nlist=document.getElementsByTagName("string");
	
	for(int temp=0; temp<nlist.getLength(); temp++) {
		
		Node node=nlist.item(temp);
		//just a separator
		if(node.getNodeType()==Node.ELEMENT_NODE) {
			
			Element element= (Element)node;
			//store each element key value in map
			stringmap.put(element.getAttribute("name"), element.getTextContent());
		}
	}return stringmap;
}

}

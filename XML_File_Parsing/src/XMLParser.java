import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {
    /*
     * Get the Document Builder
     * Get Document
     * Normalize the XML structure
     * Get all the elements by the tag name
     */
    public static void main(String[] args) {
        // Get the Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // File path to XML file
            File xmlFile = new File("items.xml");

            // Check if file exists
            if (!xmlFile.exists()) {
                System.err.println("File not found: " + xmlFile.getAbsolutePath());
                return;
            }

            // Get Document
            Document document = builder.parse(xmlFile);

            // Normalize the XML structure
            System.out.println("=========== ===============");
            document.getDocumentElement().normalize();

            // Get all the <laptop> elements
            NodeList laptopList = document.getElementsByTagName("laptop");

            for (int i = 0; i < laptopList.getLength(); i++) {
                Node laptopNode = laptopList.item(i);
                if (laptopNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element laptopElement = (Element) laptopNode;
                    System.out.println("Laptop Name: " + laptopElement.getAttribute("name"));

                    // Get child nodes of <laptop>
                    NodeList laptopDetails = laptopElement.getChildNodes();
                    for (int j = 0; j < laptopDetails.getLength(); j++) {
                        Node detailNode = laptopDetails.item(j);
                        if (detailNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detailNode;
                            System.out.println("  " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                        }
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import javax.swing.text.html.parser.Parser;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.File;
//import java.io.IOError;
//import java.io.IOException;
//import java.lang.annotation.Documented;
//
//public class XMLParser {
//    /*
//     * Get the Document Builder
//     * Get Document
//     * Normalize the xml structure
//     * Get all the element by the tag name
//     */
//    public static void main(String[] args) {
////                Get the Document Builder
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        try{
//            DocumentBuilder builder =factory.newDocumentBuilder();
//
////            Get Document
//            Document document = builder.parse(new File("items.xml"));
//
//
//            //Normalize the xml structure
//            System.out.println("=========== ==============="+document);
//            document.getDocumentElement().normalize();
//
//            //Get all the elements by the tags
//
//            NodeList ItemList = document.getElementsByTagName("items");
//
//            for(int i=0;i<ItemList.getLength();i++){
//                Node laptop = ItemList.item(i);
//                if(laptop.getNodeType() == Node.ELEMENT_NODE){
//                    Element laptopElement = (Element) laptop;
//                    System.out.println("Laptop Name: "+laptopElement.getAttribute("name"));
//
//                    NodeList laptopDetails = laptop.getChildNodes();
//                    for(int j=0;j<laptopDetails.getLength();j++){
//                        Node detail = laptopDetails.item(j);
//                        if(laptop.getNodeType() == Node.ELEMENT_NODE){
//                            Element detailElement = (Element)detail;
//                            System.out.println("  "+detailElement.getTagName()+ ": "+detailElement.getAttribute("value"));
//                        }
//                    }
//                }
//            }
//
//
//        }catch (ParserConfigurationException e){
//            e.printStackTrace();
//        }catch (SAXException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }
//}
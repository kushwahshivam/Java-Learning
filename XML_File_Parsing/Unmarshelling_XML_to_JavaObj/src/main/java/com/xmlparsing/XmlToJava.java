package com.xmlparsing;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlToJava {
    public static void main(String[] args) {
        try {
            // Case 1: Reading XML from a file
            // File file = new File("src\\main\\resources\\student.xml");

            // Case 2: If the String variable contains XML
            String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student>" +
                            "<firstName>Sarthak</firstName>" +
                            "<id>1</id>" +
                            "<lastName>Chouhan</lastName>" +
                            "</student>";

            // Create JAXB context for the Student class
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

            // Create an unmarshaller instance
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Unmarshal the XML content from the string into a Student object
            // Student student = (Student) unmarshaller.unmarshal(file);
            Student student = (Student) unmarshaller.unmarshal(new StringReader(xmlStr));

            // Print the student's first name
            System.out.println(student.getFirstName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

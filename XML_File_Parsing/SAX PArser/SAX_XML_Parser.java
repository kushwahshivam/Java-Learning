import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_XML_Parser {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bfname = false, blname = false, bscore = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                    if (qName.equals("firstName")) bfname = true;
                    if (qName.equals("lastName")) blname = true;
                    if (qName.equals("bscore")) bscore = true;
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName); // Changed to "End Element"
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bfname) {
                        System.out.println("First name: " + new String(ch, start, length)); // Corrected newString to new String
                        bfname = false;
                    }

                    if (blname) { // Fixed variable name from lname to blname
                        System.out.println("Last name: " + new String(ch, start, length));
                        blname = false;
                    }

                    if (bscore) {
                        System.out.println("Score: " + new String(ch, start, length));
                        bscore = false;
                    }
                }
            };

            // Assuming you have an XML file named "input.xml"
            saxParser.parse("input.xml", handler);

        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }
}

package domcrc7fc1026;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomWriteCRC7FC {
    public static void main(String[] args) throws ParserConfigurationException {
        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.newDocument();
            Element root = dom.createElementNS("domcrc7fc","users");
            dom.appendChild(root);
            root.appendChild(createUser(dom,"1","Gábor","Baranyi","Hallgató"));
            root.appendChild(createUser(dom,"2","Csaba","Pipa","Hallgató"));
            root.appendChild(createUser(dom,"3","Bence","Schmidt","Hallgató"));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(dom);

            File file = new File ("users1crc7fc.xml");
            StreamResult streamResult1 = new StreamResult(file);
            StreamResult streamResult2  = new StreamResult(System.out);
            transformer.transform(source, streamResult1);
            transformer.transform(source, streamResult2);

        }

        catch (ParserConfigurationException p) {
            System.out.println(p);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
    private static Node createUser(Document doc, String id,String FirstName, String lastname, String profession){
    Element user = doc.createElement("user");
    user.setAttribute("id",id);
    user.appendChild(createUserElement(doc,"firstname",FirstName));
        user.appendChild(createUserElement(doc,"lastname",lastname));
        user.appendChild(createUserElement(doc,"profession",profession));
        return user;
    }
    private static Node createUserElement(Document doc,String name, String value){
        Element element= doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        return element;
    }
}

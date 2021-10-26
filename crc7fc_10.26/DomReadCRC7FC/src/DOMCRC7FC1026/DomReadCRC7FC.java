package DOMCRC7FC1026;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadCRC7FC {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(new File("usersCRC7FC.xml"));
            dom.getDocumentElement().normalize();
            Element rootElement = dom.getDocumentElement();
            System.out.println("Gyökér elem: " + rootElement.getNodeName());
            NodeList childNodes = rootElement.getChildNodes();

            for(int i =0; i<childNodes.getLength();i++) {
                Node node = childNodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element)node;
                    String cur = element.getNodeName();
                    System.out.println("current element: "+ cur);
                    String id = element.getAttribute("id");
                    System.out.println("User id: "+ id);
                    Node actualNode = element.getFirstChild();
                    while(actualNode != null) {
                        if(actualNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element actualElement = (Element)actualNode;
                            System.out.println(" " + actualElement.getNodeName()+ ":" +actualElement.getTextContent());
                        }
                        actualNode = actualNode.getNextSibling();
                    }
                    System.out.println();
                }
            }
        } catch (ParserConfigurationException p) {
            System.out.println(p);
        } catch (SAXException e) {
            System.out.println(e);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}

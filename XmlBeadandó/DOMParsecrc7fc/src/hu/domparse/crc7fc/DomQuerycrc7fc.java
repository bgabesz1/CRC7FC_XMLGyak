package hu.domparse.crc7fc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class DomQuerycrc7fc {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //fájl bolvasása
            Document document = builder.parse(new File("XMLcrc7fc.xml"));
            document.getDocumentElement().normalize();
            //Xpath készítése
            XPath xPath= XPathFactory.newInstance().newXPath();
            //elérési út megadása
            //összes termék lekérése
            // String expression="root/Áruház/Termékek/Termék
            //csak az 55nél nagyobb id-jű termékek lekérése
            String expression="root/Áruház/Termékek/Termék[@Tkód>=55]";

            //lista készítés,path kifejezés megírása
            NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            //for ciklus nodlist csomópontjainak végig itrálása
            for (int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                //aktuális elem kiírása
                System.out.println ("\naktuális elem: " + node.getNodeName());

                //csomópont vizsgálata, találtelemek kilistázása
                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("Termék")){
                    Element element=(Element) node;
                    System.out.println("Áruház id : " + element.getAttribute("Ákód"));
                    System.out.println("Termék id : " + element.getAttribute("Tkód"));
                    System.out.println("Termék neve : " + element.getElementsByTagName("Tnév").item(0).getTextContent());
                    System.out.println("LejáratiDátum : "
                            + element.getElementsByTagName("LejáratiDátum").item(0).getTextContent());
                    System.out.println("Termék ár : " + element.getElementsByTagName("ár").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e){
            e.printStackTrace();
        }
    }

}

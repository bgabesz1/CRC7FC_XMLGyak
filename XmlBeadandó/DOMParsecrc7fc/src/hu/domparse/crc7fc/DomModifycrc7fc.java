package hu.domparse.crc7fc;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomModifycrc7fc {
    public static void main(String[] args) {
    NodeList list;
		try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // fájl beolvasása
        Document document = builder.parse(new File("XMLcrc7fc.xml"));
        document.getDocumentElement().normalize();
        // Aktuális elem meghatározása
        list = document.getElementsByTagName("Főnök");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            // Aktuális elem Kiírása
            System.out.println("\nCurrent element: " + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                //Fkód eltárolása egy stringbe
                String fkód=element.getAttribute("fkód");
                //főnök adatainak kiírása
                System.out.println("Főnök neve : "
                        + element.getElementsByTagName("Fnév").item(0).getTextContent());
                System.out.println("Főnök id: " + element.getAttribute("fkód"));
                System.out.println("Életkora : "
                        +element.getElementsByTagName("Életkor").item(0).getTextContent() );
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementszemadat = (Element) node;
                    System.out.println("Szem adat : ");
                    System.out.println("Születési helye : " + elementszemadat.getElementsByTagName("Szülhely").item(0).getTextContent());
                    System.out.println("Születési ideje : " + elementszemadat.getElementsByTagName("Szülidő").item(0).getTextContent());
                }
                Node nodefkod = list.item(i);
                if (nodefkod.getNodeType() == Node.ELEMENT_NODE) {
                    Element element1 = (Element) node;
                    //Fkód vizsgálata és ha megegyezzik 11-el akkor Név módosítása Baranyi Antalra
                    if (fkód.equals("11")) {
                        element1.getElementsByTagName("Fnév").item(0).setTextContent("Baranyi Antal");

                    }
                    //főnök új adatainak kiírás
                    System.out.println("\n Új Főnök neve: "
                            + element1.getElementsByTagName("Fnév").item(0).getTextContent());
                    System.out.println("Főnök id: " + element1.getAttribute("fkód"));
                    System.out.println("Életkora : "
                            +element.getElementsByTagName("Életkor").item(0).getTextContent() );
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementszemadat = (Element) node;
                        System.out.println("Szem adat : ");
                        System.out.println("Születési helye : " + elementszemadat.getElementsByTagName("Szülhely").item(0).getTextContent());
                        System.out.println("Születési ideje : " + elementszemadat.getElementsByTagName("Szülidő").item(0).getTextContent());

                    }
                }
            }
        }
            //Lekérdezi az adatoktak és beleírja egy fájlba
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source input=new DOMSource(document);
            Result output = new StreamResult(new File("XMLcrc7fcLekérdzett.xml"));
            transformer.transform(input, output);

    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}

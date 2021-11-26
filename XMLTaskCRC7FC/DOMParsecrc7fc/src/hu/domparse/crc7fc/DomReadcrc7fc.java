package hu.domparse.crc7fc;

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

public class DomReadcrc7fc {
    public static void main(String[] args) {
    NodeList list;
        try {
        DocumentBuilderFactory documentBuilderFactoryfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactoryfactory.newDocumentBuilder();

        // beolvassuk a fájlt
        Document document = documentBuilder.parse(new File("XMLcrc7fc.xml"));
        document.getDocumentElement().normalize();
        //meghatározzuk az aktuális elemet
        list = document.getElementsByTagName("Főnök");
        for(int i = 0; i<list.getLength(); i++) {
            Node node = list.item(i);
            //aktuális elem kiírása
            System.out.println("Jelenlegi elem: " + node.getNodeName());

            //Főnök adatainak kiírása
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Főnök id : " + element.getAttribute("fkód"));
                System.out.println("Főnök neve: "
                        + element.getElementsByTagName("Fnév").item(0).getTextContent());
                System.out.println("Kora : "
                        + element.getElementsByTagName("Életkor").item(0).getTextContent());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementszemadat = (Element) node;
                    System.out.println("Szem adat : ");
                    System.out.println("Születési helye : " + elementszemadat.getElementsByTagName("Szülhely").item(0).getTextContent());
                    System.out.println("Születési ideje : " + elementszemadat.getElementsByTagName("Szülidő").item(0).getTextContent());

                }

            }

        }
        list = document.getElementsByTagName("Áruház");
        for(int j = 0; j<list.getLength(); j++) {
            //Áruház adatainak kiírása
            Node arunode = list.item(j);
            //aktuális elem kiírása
            System.out.println("\nJelenlegi elem: " + arunode.getNodeName());
            if (arunode.getNodeType() == Node.ELEMENT_NODE) {
                Element elementaruhaz = (Element) arunode;
                //áruház adatainak kiírása
                System.out.println("Áruház id : " + elementaruhaz.getAttribute("Ákód"));
                System.out.println("Áruház Neve : " + elementaruhaz.getElementsByTagName("Ánév").item(0).getTextContent());
                System.out.println("Elhelyezkedése : " + elementaruhaz.getElementsByTagName("Hely").item(0).getTextContent());
                System.out.println("Alapítási éve : " + elementaruhaz.getElementsByTagName("Alapításiév").item(0).getTextContent());

            }

        }
        list =document.getElementsByTagName("Dolgozók");
        Node dolgozókknode = list.item(0);
            //aktuális elem kiírása
        System.out.println("\nJelenlegi elem: " + dolgozókknode.getNodeName());
        if (dolgozókknode.getNodeType() == Node.ELEMENT_NODE) {
            Element dokelement = (Element) dolgozókknode;
            //Dolgozók attribútumának kiírása mely a dolgozók fizetése
            System.out.println("Dolgozói fizetés : " + dokelement.getAttribute("fizetés"));
            for(int k = 0; k<list.getLength(); k++) {
                list = document.getElementsByTagName("Dolgozó");
                Node donode = list.item(k);
                //aktuális elem kiírása
                System.out.println("\nJelenlegi elem: " + donode.getNodeName());
                if (donode.getNodeType() == Node.ELEMENT_NODE) {
                    Element doelement = (Element) donode;
                    //Dolgozók adatainak kiírása
                    String Dkód = doelement.getAttribute("Dkód");
                    System.out.println("Áruház id : " + doelement.getAttribute("Ákód"));
                    System.out.println("Dolgozó id : " + doelement.getAttribute("Dkód"));
                    System.out.println("Dolgozó neve: "
                            + doelement.getElementsByTagName("Dnév").item(0).getTextContent());
                    //Dolgozó beosztásának kiírása dkód alapján
                    list = document.getElementsByTagName("Beosztás");
                    for(int l = 0; l<list.getLength(); l++) {
                        Node Benode = list.item(l);
                        if (dolgozókknode.getNodeType() == Node.ELEMENT_NODE) {
                            Element Beelement = (Element) Benode;
                            String dolgozó = Beelement.getAttribute("Dolgozó");
                            //ha a beosztás dolgozók kódja megegyezik a dolgozók dkódjával akkor kiírjuk a napszakát
                            if (Dkód.equals(dolgozó)) {
                                System.out.println("Beosztása : " + Beelement.getElementsByTagName("napszak").item(0).getTextContent());
                            }
                        }
                    }
                    if (donode.getNodeType() == Node.ELEMENT_NODE) {
                        Element elementdoszemadat = (Element) donode;
                        System.out.println("Szem adat : ");
                        System.out.println("Születési helye : " + elementdoszemadat.getElementsByTagName("Szülhely").item(0).getTextContent());
                        System.out.println("Születési ideje : " + elementdoszemadat.getElementsByTagName("Szülidő").item(0).getTextContent());

                    }
                }
            }
        }
        list =document.getElementsByTagName("Vásárlók");
        Node Vásáknode = list.item(0);
            //aktuális elem kiírása
        System.out.println("\nJelenlegi elem: " + Vásáknode.getNodeName());
        list = document.getElementsByTagName("Vásárló");
        for(int k = 0; k<list.getLength(); k++) {
            Node Vánode = list.item(k);
            //aktuális elem kiírása
            System.out.println("\nJelenlegi elem: " + Vánode.getNodeName());
            if (Vánode.getNodeType() == Node.ELEMENT_NODE) {
                Element Váelement = (Element) Vánode;
                //Vásárlók adatainak kiírása
                System.out.println("Áruház id : " + Váelement.getAttribute("Ákód"));
                System.out.println("Vásárló id : " + Váelement.getAttribute("Vkód"));
                System.out.println("Vásárló neve: " + Váelement.getElementsByTagName("Vnév").item(0).getTextContent());
                System.out.println("Kora : "
                        + Váelement.getElementsByTagName("Életkor").item(0).getTextContent());
                if (Vánode.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementvaszemadat = (Element) Vánode;
                    System.out.println("Szem adat : ");
                    System.out.println("Születési helye : " + elementvaszemadat.getElementsByTagName("Szülhely").item(0).getTextContent());
                    System.out.println("Születési ideje : " + elementvaszemadat.getElementsByTagName("Szülidő").item(0).getTextContent());

                }

            }
        }
            list =document.getElementsByTagName("Termékek");
            Node Terméknode = list.item(0);
            //aktuális elem kiírása
            System.out.println("\nJelenlegi elem : " + Terméknode.getNodeName());
            list = document.getElementsByTagName("Termék");
            for(int k = 0; k<list.getLength(); k++) {
                Node tenode = list.item(k);
                //aktuális elem kiírása
                System.out.println("\nJelenlegi elem : " + tenode.getNodeName());
                if (tenode.getNodeType() == Node.ELEMENT_NODE) {
                    Element Telement = (Element) tenode;
                    //Termékek adatainak kiírása
                    System.out.println("Áruház id : " + Telement.getAttribute("Ákód"));
                    System.out.println("Termék id : " + Telement.getAttribute("Tkód"));
                    System.out.println("Termék neve : " + Telement.getElementsByTagName("Tnév").item(0).getTextContent());
                    System.out.println("LejáratiDátum : "
                            + Telement.getElementsByTagName("LejáratiDátum").item(0).getTextContent());
                    System.out.println("Termék ár : " + Telement.getElementsByTagName("ár").item(0).getTextContent());
                }
            }
            list =document.getElementsByTagName("Termékek");
            Node menynode = list.item(0);
            if (dolgozókknode.getNodeType() == Node.ELEMENT_NODE) {
                Element menyelement = (Element) menynode;
                //eladott és vásárolt mennyiség kiírása
                System.out.println("\nAz eladott mennyiség : " + menyelement.getAttribute("Eladottmennyiség")+" .\nTehát a vásárlók " + menyelement.getAttribute("Eladottmennyiség")+" ásároltak.");
            }

        } catch (
    ParserConfigurationException e) {
        e.printStackTrace();
    } catch (
    IOException e) {
        e.printStackTrace();
    } catch (
    SAXException e) {
        e.printStackTrace();
    }
}
}

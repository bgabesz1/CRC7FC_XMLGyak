package SaxCRCZFC1020;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.jar.Attributes;

public class SaxCRC7FC {

    public static void main(String[] args) {

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                indent++;
                indent();
                System.out.println(qName + formatAttributes(attributes) + "start");
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                indent();
                indent--;
                System.out.println(qName + "end");
            }

            @Override
            public void characters(chard ch[], int start, int length) {
                String chars = new String(ch, start, length);
                indent++;
                indent();
                indent--;
                System.out.println(chars);
            }

            try {

                SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

                SAXParser saxParser = saxParserFactory.newSAXParser();

                SaxHandler handler = new SaxHandler();

                saxParser.parse(new File("macskakCRC7FC.xml"), handler);

            }
            catch (ParserConfigurationException | SAXException | IOException e){

                e.printStackTrace();

            }

        }

    }

package SaxCRC7FC1020;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxCRC7FC {
    public static void main(String[] args) {

    }
}
class SaxHandler extends DefaultHandler {
    private int indent=0;

    private String formatAttributes(Attributes attributes){
        int attrLenght=attributes.getLength();
        if (attrLenght==0){
            return " ";
        }
        StringBuilder sb=new StringBuilder(", {");
        for (int i=0;i<attrLenght;i++){
            sb.append(attributes.getLocalName(i)+":"+attributes.getValue(i));
            if (i<attrLenght-1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
    private void indent(){
        for (int i=0;i<indent;i++){
            System.out.print(" ");
        }
    }
    @Override
    public void startElement(String uri,String localName,String qName,Attributes attributes){
        indent++;
        indent();
        System.out.println(qName+formatAttributes(attributes)+" start");
    }
    @Override
    public void endElement(String uri,String localName,String qName){
        indent();
        indent--;
        System.out.println(qName+" end");
    }
    @Override
    public void characters(char ch[],int start,int lenght){
        String chars=new String(ch,start,lenght).trim();
        if (!chars.isEmpty()){
            indent++;
            indent();
            indent--;
            System.out.println(chars);
        }
    }

}

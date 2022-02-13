package xml;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMparserDemo {
	public static void main(String[] args) {
        try{
            File f = new File("input.xml");
            DocumentBuilderFactory f1 = DocumentBuilderFactory.newInstance();
            DocumentBuilder d = f1.newDocumentBuilder();
            Document doc = d.parse(f);
            doc.getDocumentElement().normalize();
            System.out.println("root element:"+doc.getDocumentElement().getNodeName());
            NodeList nl = doc.getElementsByTagName("student");
            System.out.println("---------------------");
            for(int t=0;t<nl.getLength();t++){
                Node n = nl.item(t);
                System.out.println("current element:"+ n.getNodeName());
                if (n.getNodeType()==Node.ELEMENT_NODE){
                    Element e = (Element) n;
                    System.out.println("student rollno"+ e.getAttribute("rollno"));
                    System.out.println("firstname:"+e.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("lastname:"+e.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("marsks:"+e.getElementsByTagName("marks").item(0).getTextContent());
                    System.out.println("address:"+e.getElementsByTagName("address").item(0).getTextContent());
                }
            }
        }
        catch( Exception e){
            e.printStackTrace();
        }
    }
}

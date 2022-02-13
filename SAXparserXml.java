package xml;
import java.io.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXparserXml extends DefaultHandler{
	boolean studentid = true, name=false, address=false, gender=false;
	int flag=0, c=0;
	String sid, sname, sadd, sgender, tid ;
	public void startDocument() {
		System.out.println("Begin parsing document");
		System.out.println("Enter studentid:\t");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			tid = reader.readLine();
		}
		catch (Exception e) {}
	}
	public void startElement(String url, String localname, String qName, Attributes alt) {
		if (qName.equalsIgnoreCase("studentid")) {
			studentid = true;
		}
		else if (qName.equalsIgnoreCase("name") && flag == 1) {
			name = true;
		}
		else if (qName.equalsIgnoreCase("gender") && flag == 1) {
			gender = true;
		}
	}
	public void characters(char[] ch, int start, int length) {
		if (studentid) {
			String x = new String(ch, start, length);
			if (x.equals(tid)) {
				flag = 1;
				sid = x;
				c = 1;
			}
			else
				flag = 0;
			studentid = false;
		}
		else if (name) {
			sname = new String (ch, start, length);
			name = false;
		}
		else if (address) {
			sadd = new String (ch, start, length);
			address = false;
		}
		else if (gender) {
			sgender = new String (ch, start, length);
			gender = false;
		}
	}
	public void endElement(String url, String localname, String qName) {}
	public void EndDocument() {
		if (c==0) 
			System.out.println("StudentId is not present.......Try Again!!!!!!");
		else {
			System.out.println("Student Details");
			System.out.println("-----------------");
			System.out.println("Student id"+sid);
			System.out.println("Student name"+sname);
			System.out.println("address"+sadd);
			System.out.println("gender:"+sgender);
		}
	}
	public static void main(String[] args) throws Exception{
		SAXParser p = SAXParserFactory.newInstance().newSAXParser();
		p.parse(new FileInputStream("Student.xml"), new SAXparserXml());
		}
}

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class test01_dom4j {
    public static void main(String[] args) throws DocumentException {
        SAXReader sax =new SAXReader();
        String file = test01_dom4j.class.getClassLoader().getResource("bean.xml").getFile();
        Document read = sax.read(file);
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String className = element.attributeValue("className");
            System.out.println(id+" "+className);
            List<Element> list = element.elements();
            for (Element ele : list) {
                String name = ele.attributeValue("name");
                String value = ele.attributeValue("value");
                System.out.println(name + " " + value);
            }
        }
    }
}

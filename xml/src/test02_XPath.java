import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class test02_XPath {
    public static void main(String[] args) throws DocumentException {
        SAXReader sax = new SAXReader();
        String file = test02_XPath.class.getClassLoader().getResource("student.xml").getFile();
        Document document = sax.read(file);
        List<Node> nodes = document.selectNodes("//student");
        for (Node node : nodes) {
            System.out.println(node);

        }
        System.out.println("--------------------------");
        List<Node> list = document.selectNodes("//student/name");
        for (Node node : list) {
            System.out.println(node);
        }
        System.out.println("-----------------------------------");
        List<Node> list1 = document.selectNodes("//student/name[@id]");
        for (Node node : list1) {
            System.out.println(node);

        }
        System.out.println("-----------------------------------");

        List<Node> list2 = document.selectNodes("//student/name[@id='itcast']");
        for (Node node : list) {
            System.out.println(node);

        }


    }
}

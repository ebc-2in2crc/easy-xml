import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;

public class Sample4 {
    public static void main(String[] args) throws Exception {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document doc = builder.parse(new FileInputStream("sample.xml"));

        final Element root = doc.getDocumentElement();
        walk(root);
    }

    private static void walk(Node node) {
        for (Node childNode = node.getFirstChild();
             childNode != null;
             childNode = childNode.getNextSibling()) {
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(childNode.getNodeName());
            }
        }
    }
}

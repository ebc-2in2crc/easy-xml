import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;

public class Sample5 {
    public static void main(String[] args) throws Exception {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document doc = builder.parse(new FileInputStream("sample.xml"));

        final Element root = doc.getDocumentElement();
        walk(root);

        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(doc), new StreamResult("result.xml"));
    }

    private static void walk(Node node) {
        for (Node childNode = node.getFirstChild();
             childNode != null;
             childNode = childNode.getNextSibling()) {
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                if (childNode.getNodeName().equals("car")) {
                    final NamedNodeMap attributes = childNode.getAttributes();
                    attributes.removeNamedItem("country");
                }
                walk(childNode);
            }
        }
    }
}

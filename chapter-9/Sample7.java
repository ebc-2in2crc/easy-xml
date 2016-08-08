import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;

public class Sample7 {
    public static void main(String[] args) throws Exception {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document inputDoc = builder.parse(new FileInputStream("sample.xml"));
        final Document outputDoc = builder.newDocument();

        final Element root = outputDoc.createElement("cars");
        outputDoc.appendChild(root);

        final NodeList names = inputDoc.getElementsByTagName("name");
        for (int i = 0; i < names.getLength(); i++) {
            final Node name = names.item(i);
            for (Node childNode = name.getFirstChild();
                    childNode != null;
                    childNode = childNode.getNextSibling()) {
                if (childNode.getNodeValue().contains("車")) {
                    final Text text = outputDoc.createTextNode(childNode.getNodeValue());
                    final Element element = outputDoc.createElement("name");
                    element.appendChild(text);
                    root.appendChild(element);
                }
            }
        }

        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(outputDoc), new StreamResult("result.xml"));
    }

}

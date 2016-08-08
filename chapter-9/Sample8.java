import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;

public class Sample8 {
    public static void main(String[] args) throws Exception {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document inputDoc = builder.parse(new FileInputStream("sample.xml"));
        final Document outputDoc = builder.newDocument();

        final Element root = outputDoc.createElement("cars");
        outputDoc.appendChild(root);

        final NodeList names = inputDoc.getElementsByTagName("car");
        for (int i = 0; i < names.getLength(); i++) {
            final Node name = names.item(i);

            final NamedNodeMap attributes = name.getAttributes();
            Node attr = attributes.getNamedItem("country");
            final Text text = outputDoc.createTextNode(attr.getNodeValue());

            final Element country = outputDoc.createElement("country");
            country.appendChild(text);
            root.appendChild(country);
        }

        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(outputDoc), new StreamResult("result.xml"));
    }

}

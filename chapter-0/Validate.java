import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validate {
    public static void main(String[] args) throws IOException, SAXException {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        StreamSource xs = new StreamSource(new File(args[1]));
        Schema schema = sf.newSchema(xs);
        Validator validator = schema.newValidator();

        StreamSource in = new StreamSource(new File(args[0]));
        try {
            validator.validate(in);
            System.out.println("妥当な文書です");
        } catch (SAXException e) {
            System.out.println(e.toString());
        }
    }
}

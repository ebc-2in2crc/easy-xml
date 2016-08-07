import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class Transform {
    public static void main(String[] args) throws TransformerException {
        StreamSource in = new StreamSource(new File(args[0]));
        StreamSource ss = new StreamSource(new File(args[1]));
        StreamResult out = new StreamResult(new File(args[2]));

        final Transformer transformer = TransformerFactory.newInstance().newTransformer(ss);
        transformer.transform(in, out);

        System.out.println(args[2] + "に出力しました");
    }
}

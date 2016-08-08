import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;

public class Sample1 {
    public static void main(String[] args) throws Exception {
        final SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        final SampleHandler1 handler = new SampleHandler1();

        parser.parse(new FileInputStream("sample.xml"), handler);
    }

    private static class SampleHandler1 extends DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("XML 文書が開始しました。");
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("XML 文書が終了しました。");
        }
    }
}

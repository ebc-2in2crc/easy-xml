import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;

public class Sample2 {
    public static void main(String[] args) throws Exception {
        final SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        final SampleHandler2 handler = new SampleHandler2();

        parser.parse(new FileInputStream("sample.xml"), handler);
    }

    private static class SampleHandler2 extends DefaultHandler {

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

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            System.out.println(qName + " 要素が開始しました。");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            System.out.println(qName + " 要素が終了しました。");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);

            final String s = new String(ch, start, length);
            if (s.trim().length() == 0) {
                return;
            }

            System.out.println(s);
        }
    }
}

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Sample3 {
    public static void main(String[] args) throws Exception {
        final SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        final SampleHandler3 handler = new SampleHandler3();

        parser.parse(new FileInputStream("sample.xml"), handler);
    }

    private static class SampleHandler3 extends DefaultHandler {

        private StringBuilder builder = new StringBuilder();
        private boolean isPrint = false;

        @Override
        public void startDocument() throws SAXException {
            builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            builder.append("<cars>");
        }

        @Override
        public void endDocument() throws SAXException {
            builder.append("</cars>");
            try {
                final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.xml"));
                bufferedWriter.write(builder.toString());
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);

            if (!qName.equals("name")) {
                return;
            }

            builder.append("<").append(qName).append(">");
            isPrint = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);

            if (!qName.equals("name")) {
                return;
            }

            builder.append("</").append(qName).append(">");
            isPrint = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);

            final String s = new String(ch, start, length);
            if (s.trim().length() == 0 || !isPrint) {
                return;
            }

            builder.append(s);
        }
    }
}

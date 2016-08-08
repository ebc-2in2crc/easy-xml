import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Sample4 {
    public static void main(String[] args) throws Exception {
        final SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        final SampleHandler4 handler = new SampleHandler4();

        parser.parse(new FileInputStream("sample.xml"), handler);
    }

    private static class SampleHandler4 extends DefaultHandler {

        private StringBuilder builder = new StringBuilder();

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

            if (!qName.equals("car")) {
                return;
            }

            builder.append("<").append(qName).append(">");

            for (int i = 0; i < attributes.getLength(); i++) {
                builder.append("<").append(attributes.getQName(i)).append(">");
                builder.append(attributes.getValue(i));
                builder.append("</").append(attributes.getQName(i)).append(">");
            }

            builder.append("</").append(qName).append(">");
        }
    }
}

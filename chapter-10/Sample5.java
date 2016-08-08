import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Sample5 {
    public static void main(String[] args) throws Exception {
        final SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        final SampleHandler4 handler = new SampleHandler4();

        parser.parse(new FileInputStream("sample.xml"), handler);
    }

    private static class SampleHandler4 extends DefaultHandler {

        private static Map<String, String> dic;
        static {
            dic = new HashMap<>();
            dic.put("cars", "車リスト");
            dic.put("car", "車");
            dic.put("name", "品名");
            dic.put("price", "価格");
        }

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
            if (!dic.containsKey(qName)) {
                return;
            }

            builder.append("<").append(dic.get(qName)).append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!dic.containsKey(qName)) {
                return;
            }

            builder.append("</").append(dic.get(qName)).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);

            final String s = new String(ch, start, length);
            if (s.trim().length() == 0) {
                return;
            }

            builder.append(s);
        }
    }
}

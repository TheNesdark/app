package Utilidades.corrector.jorthodictionaries;

import Utilidades.corrector.jortho.Utils;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jorthodictionaries/Parser.class */
public class Parser extends DefaultHandler {
    private final BookGenerator generator;
    private int currentTag;
    private String word;
    private String text;
    private final int NONE = 0;
    private final int TITLE = 1;
    private final int TEXT = 2;
    private final StringBuilder data = new StringBuilder();

    Parser(BookGenerator generator, InputStream stream) throws Exception {
        this.generator = generator;
        System.setProperty("entityExpansionLimit", "100000000");
        InputSource input = new InputSource(new InputStreamReader(stream, "utf8"));
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        ParserAdapter pa = new ParserAdapter(sp.getParser());
        pa.setContentHandler(this);
        pa.parse(input);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (this.currentTag) {
            case 1:
            case 2:
                this.data.append(ch, start, length);
                break;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.data.setLength(0);
        if ("title".equals(localName)) {
            this.currentTag = 1;
        } else if ("text".equals(localName)) {
            this.currentTag = 2;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        switch (this.currentTag) {
            case 1:
                this.word = this.data.toString();
                this.word = Utils.replaceUnicodeQuotation(this.word);
                if (!this.generator.isValidWord(this.word)) {
                    this.word = null;
                }
                break;
            case 2:
                this.text = this.data.toString();
                break;
            default:
                if ("page".equals(localName) && this.word != null) {
                    try {
                        this.generator.getBook().incTitleCount();
                        this.text = Utils.replaceUnicodeQuotation(this.text);
                        if (this.generator.isValidLanguage(this.word, this.text)) {
                            this.generator.getBook().incLanguageTitleCount();
                            this.generator.addWord(this.word);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                break;
        }
        this.currentTag = 0;
    }
}

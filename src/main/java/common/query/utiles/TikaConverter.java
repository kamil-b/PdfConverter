package common.query.utiles;

import org.apache.commons.io.FileUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TikaConverter {


    public void parsePdfToTxt(String inputText, String outputFile) throws IOException, TikaException, SAXException {
        BodyContentHandler handler = new BodyContentHandler();
        PDFParser pdfparser = new PDFParser();

        pdfparser.parse(new FileInputStream(new File(inputText)), handler, new Metadata(), new ParseContext());

        FileUtils.writeStringToFile(new File(outputFile), handler.toString(), "UTF-8");
    }

    public static String parseToPlainText(String in, String out) throws IOException, SAXException, TikaException {
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();

        try (InputStream stream = new FileInputStream(new File(in))) {
            parser.parse(stream, handler, metadata);
            FileUtils.writeStringToFile(new File(out), handler.toString(), "UTF-8");
            return handler.toString();
        }
    }
}

package common.query.utiles;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;


public class PdfBoxConverter {

    public static void parsePdfToTxt(String inputText, String outputFile) throws IOException {
        String content = new PDFTextStripper().getText(PDDocument.load(new File(inputText)));
        FileUtils.writeStringToFile(new File(outputFile), content, "UTF-8");
    }

}

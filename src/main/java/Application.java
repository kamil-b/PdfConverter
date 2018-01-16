import common.query.utiles.PdfConverter;
import common.query.utiles.TikaConverter;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Application {
    public static String path = "C:\\cvs\\Application\\aleksandra_orginal_CV.pdf";
    public static String out1 = "C:\\cvs\\Application\\aleksandra_pdfbox.txt";
    public static String out2 = "C:\\cvs\\Application\\aleksandra_tika.txt";
    private static int counter = 0;
    private static int numberOfThreads = 2;
    private static String outputDirecotry = "";

    public static void main(String[] args) {
      PdfConverter converter = new PdfConverter(path, outputDirecotry , numberOfThreads);

    }
/*
    public static void listFilesAndFilesSubDirectories(String directoryName) {
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            for (File file2 : file.listFiles()) {
                System.out.println(file2);
                try {
                    TikaConverter.parsePdfToTxt(file2.toString(), "C:\\vs\\pdfs\\converted3" + file2.getParent() + ".txt");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TikaException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (ClassCastException e) {
                    e.printStackTrace();

                }
            }
        }
        }
        */

}

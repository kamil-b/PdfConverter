import common.query.utiles.TikaConverter;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class test {
    public static String path = "C:\\cvs\\test\\aleksandra_orginal_CV.pdf";
    public static String out1 = "C:\\cvs\\test\\aleksandra_pdfbox.txt";
    public static String out2 = "C:\\cvs\\test\\aleksandra_tika.txt";
    private static int counter = 0;

    public static void main(String[] args) {

       // listFilesAndFilesSubDirectories("\\\\crm01\\new_cv\\2011 12\\");
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

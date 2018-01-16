package common.query.utiles;

import common.query.thread.ConverterTaskMenager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class PdfConverter {

    private ConverterTaskMenager taskMenager;
    private String pathToDirectory;


    public PdfConverter(String pathToDirectory, String outputDirectory, int numberOfThreads) {
        this.pathToDirectory = pathToDirectory;
        this.taskMenager = new ConverterTaskMenager(numberOfThreads, collectPdfFiles());
    }

    private Collection<File> collectPdfFiles() {
        return FileUtils.listFiles(new File(this.pathToDirectory), new String[]{"pdf"}, true);
    }


}

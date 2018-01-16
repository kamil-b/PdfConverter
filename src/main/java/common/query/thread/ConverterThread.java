package common.query.thread;

import common.query.utiles.TikaConverter;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

class ConverterThread implements Runnable {

    private TikaConverter converter = new TikaConverter();
    private BlockingQueue<File> sharedQueue;


    ConverterThread(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            if (isNotEmpty()) {
                convert(sharedQueue.take(), new File(""));
            }
        } catch (InterruptedException | TikaException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void convert(File inputfile, File outputFile) throws TikaException, IOException, SAXException {
        converter.parsePdfToTxt(inputfile, outputFile);
    }

    private boolean isNotEmpty() {
        return !sharedQueue.isEmpty();
    }
}

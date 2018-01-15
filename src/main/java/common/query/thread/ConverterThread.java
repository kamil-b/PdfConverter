package common.query.thread;

import common.query.utiles.TikaConverter;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class ConverterThread implements Runnable {

    private TikaConverter converter = new TikaConverter();
    private boolean readyForNextConvertation = true;
    private String destination;

    ConverterThread(String destination) {
        this.destination = destination;
    }


    @Override
    public void run() {
        try {
            converter.parsePdfToTxt("", destination);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }


}

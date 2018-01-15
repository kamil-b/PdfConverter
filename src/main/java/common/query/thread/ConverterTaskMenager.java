package common.query.thread;

import java.io.File;

public class ConverterTaskMenager {

    private File sourceFolder;
    private int threads;

    ConverterTaskMenager(File folder, int threads) {
        this.sourceFolder = folder;
        this.threads = threads;
    }

    public void start(){

    }
}

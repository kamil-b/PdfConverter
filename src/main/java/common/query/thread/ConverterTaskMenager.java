package common.query.thread;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class ConverterTaskMenager {
    private List<Runnable> threads = new ArrayList<>();
    private BlockingQueue<File> sharedQueue = new ArrayBlockingQueue<>(200);

    public ConverterTaskMenager(int numberOfThreads, Collection<File> files) {
        this.sharedQueue.addAll(files);
        createThreads(numberOfThreads);
        start();
    }

    private void createThreads(int numberOfThreads) {
        IntStream.range(0, numberOfThreads).forEach(number -> {
            //logging
            threads.add(new ConverterThread(sharedQueue));
        });
    }

    public void start() {
        threads.forEach(thread -> thread.run());
    }
}

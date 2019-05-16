package lesson_12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jur on 03.02.2019.
 */
public class CounterTest {

    @Test
    public void increase() throws InterruptedException {
        final Counter counter = new Counter();
        final List<Reader> readers = Arrays.asList(
                new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter),
                new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter)
        );

        for (final Reader reader : readers) {
            reader.start();
        }
        Thread.sleep(1000L);
        assertEquals(1201, counter.increase());
    }

    private static class Reader extends Thread {
        private final Counter counter;

        public Reader(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i != 100; i++) {
                System.err.println(String.format("%s : %s", Thread.currentThread().getId(), this.counter.increase()));
            }
        }
    }
}

package lesson_12;

import calculator.User;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jur on 03.02.2019.
 */
public class BlockQueueTest {
    @Test
    public void queue() throws InterruptedException {
        final BlockQueue<User> queue = new BlockQueue<>();
        final List<Customer> customers = Arrays.asList(new Customer(queue), new Customer(queue));
        for (Customer customer : customers) {
            customer.start();
        }

        Producer producer = new Producer(
                queue, Arrays.asList(
                new User("1", "1"), new User("2", "2"),
                new User("3", "3"), new User("4", "4")
        )
        );
        producer.start();

        producer.join();
        Thread.sleep(10L);
        int count = 0;
        for (Customer customer : customers) {
            count += customer.size();
        }
        assertEquals(count, producer.size());//сравниваем, столько куплено и сколько произведено
    }

    //записывают данные
    private static final class Producer extends Thread {
        private final BlockQueue<User> queue;
        private final List<User> store;

        public Producer(final BlockQueue<User> queue, final List<User> store) {
            super();
            this.queue = queue;
            this.store = store;
        }

        public void run() {
            for (User user : this.store) {
                this.queue.push(user);
            }
        }
        public int size() {
            return this.store.size();
        }

    }

    /**
     * Покупатель
     */
    private static final class Customer extends Thread {
        private final BlockQueue<User> queue;
        private final AtomicInteger counter = new AtomicInteger(0);

        public Customer(final BlockQueue<User> queue) {
            super();
            this.queue = queue;
        }

        public void run() {
            while (true) {
                System.err.println(
                        String.format("%s : %s", Thread.currentThread().getId(), this.queue.poll())
                );
                counter.incrementAndGet();
            }
        }

        public int size() {
            return this.counter.get();
        }

    }


}


package lesson_12;

import java.util.LinkedList;

/**
 * Created by jur on 03.02.2019.
 */
public class BlockQueue<T> {
    public final LinkedList<T> queue = new LinkedList<T>();

    public void push(final T t) {
        synchronized (this.queue) {
            this.queue.add(t);
            this.queue.notifyAll();//сообщаем, что с данной очередью можно продолжать работать тем потокам, котрые ожидают этой очереди
        }
    }

    /**
     * удаление из очереди
     * @return
     */
    public T poll() {
        synchronized (this.queue) { //блок синхронизации очереди т.е. когда данный моток работает с очередью queue, то другие потоки не могут с ней работать
            while (this.queue.isEmpty()) {
                try {
                    this.queue.wait(); //Если очередь пуста, то поток отдает эту очередь бругим потокам и ждем, когда они сообщат, что можно продолжать с ней работать
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.queue.remove();
        }
    }
}

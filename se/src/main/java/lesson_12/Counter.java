package lesson_12;

/**
 * Created by jur on 03.02.2019.
 */
public class Counter {
    private int amount;

    public synchronized int increase(){
        amount++;
        return amount;
    }

    public static synchronized void echo(){

    }

}

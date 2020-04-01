package by.gstu.Entity;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * A class that models the addition and extraction of results from a queue.
 * @author Solodkov M.A, ITP-31
 * @version 1.0
 */
public class Resources{
    private Queue<String> turn; //queue
    private static Resources instance;
    private final int capacity; //queue capacity
    private int count; //real queue size
    private Resources(){
            turn = new ArrayDeque();
            capacity = 5;
            count = 0;
    }

    public static Resources getInstance(){ //Singleton
        if (instance == null){
            instance = new Resources();
        }
        return instance;
    }

    /**
     * Method for adding items to the queue
     * @param value Transmitted value
     */
    public synchronized void Offer(String value) throws InterruptedException {
        if (count == capacity) {
            wait();
        }
        turn.offer(value);
        count += 1;
        notify();
    }

    /**
     * Method for retrieving results from a queue
     * @return the last value from the queue
     */
    public synchronized String Poll(){
        if (count == 0) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count -= 1;
        notify();
        return turn.poll();
    }
}

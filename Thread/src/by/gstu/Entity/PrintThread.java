package by.gstu.Entity;

/**
 * Class for outputting data from the queue.
 * @author Solodkov M.A
 * @version 1.0
 */
public class PrintThread implements Runnable{
    private Resources resources;

    public PrintThread(Resources resources){
        this.resources = resources;
    }
    @Override
    public void run() {
        String value;
        while ((value = resources.Poll()) != null){
            System.out.println(value);
        }
    }
}

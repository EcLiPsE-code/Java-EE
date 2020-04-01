package by.gstu.Entity;

/**
 * Class for calculating sine and cosine values.
 * @author Solodkov M.A
 * @version 1.0
 */
public abstract class ComputingStream implements Runnable {
    private double x1, x2, h;
    private String nameFunc;
    private Resources resources;

    public ComputingStream(double x1, double x2, double h, String nameFunc, Resources resources){
        this.x1 = x1;
        this.x2 = x2;
        this.h = h;
        this.nameFunc = nameFunc;
        this.resources = resources;
    }

    /**
     *
     */
    @Override
    public void run() {
        synchronized (resources){
            double x = x1;
            while (x <= x2){
                try {
                    resources.Offer(String.format("%s(%.2f) = %.4f", nameFunc, x, Func(x)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x += h;
            }
        }
    }

    /**
     * Method that calculates the sine and cosine values
     */
    public abstract double Func(double x);
}

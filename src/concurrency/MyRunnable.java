package concurrency;

public class MyRunnable implements Runnable {
    private final int id;
    private final Thread t = new Thread(this);

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("MyRunnable {id=%d}", id);
    }

    @Override
    public void run() {
        System.out.println("Running " + this);
    }

    public void start() {
        t.start();
    }
}



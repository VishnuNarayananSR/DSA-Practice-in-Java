package concurrency;

public class MyThread extends Thread {
    private final int id;

    public MyThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Running " + this);
    }

    @Override
    public String toString() {
        return String.format("MyThread {id=%s}", id);
    }
}

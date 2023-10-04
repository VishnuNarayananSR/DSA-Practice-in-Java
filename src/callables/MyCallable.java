package callables;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private final int id;

    public MyCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return String.format("Calling " + this);
    }

    @Override
    public String toString() {
        return String.format("Callable {id=%d} using thread %s", id, Thread.currentThread().getName());
    }
}

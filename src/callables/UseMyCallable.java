package callables;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseMyCallable {
    public static void main(String[] args) {
        List<Callable<String>> callables = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .map(MyCallable::new)
                .collect(Collectors.toList());

        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = null;
        try {
            futures = service.invokeAll(callables);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }
}

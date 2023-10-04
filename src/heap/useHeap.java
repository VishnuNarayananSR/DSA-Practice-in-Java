package heap;

public class useHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(10);
        minHeap.add(15);
        minHeap.add(20);
        System.out.println(minHeap.items);
        minHeap.add(9);
        minHeap.add(25);
        System.out.println("Min heap:");
        System.out.println(minHeap.items);
        System.out.printf("Poll: %d%n", minHeap.poll());
        System.out.println(minHeap.items);
        System.out.printf("Peek: %d%n", minHeap.peek());
        System.out.println(minHeap.items);

        System.out.println("Max heap:");
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(15);
        maxHeap.add(20);
        maxHeap.add(17);
        System.out.println(maxHeap.items);
        maxHeap.add(15);
        maxHeap.add(10);
        maxHeap.add(28);
        System.out.println(maxHeap.items);
        System.out.printf("Poll: %d%n", maxHeap.poll());
        System.out.println(maxHeap.items);
        System.out.printf("Peek: %d%n", maxHeap.peek());
        System.out.println(maxHeap.items);
    }
}

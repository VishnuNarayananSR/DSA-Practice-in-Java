package heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class Heap {
    ArrayList<Integer> items = new ArrayList<>();

    protected int getSize() {
        return items.size();
    }

    protected int parentIndex(int index) {
        return (index - 1) / 2;
    }

    protected int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    protected int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    protected boolean hasParent(int index) {
        return parentIndex(index) >= 0;
    }

    protected boolean hasLeftChild(int index) {
        return leftChildIndex(index) < getSize();
    }

    protected boolean hasRightChild(int index) {
        return rightChildIndex(index) < getSize();
    }

    protected int parent(int index) {
        return items.get(parentIndex(index));
    }


    protected int leftChild(int index) {
        return items.get(leftChildIndex(index));
    }

    protected int rightChild(int index) {
        return items.get(rightChildIndex(index));
    }

    protected int peek() {
        if (getSize() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return items.get(0);
    }

    protected int poll() {
        if (getSize() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int tmp = items.get(0);
        items.set(0, items.get(getSize() - 1));
        items.remove(getSize() - 1);
        heapifyDown();
        return tmp;
    }

    protected void add(int key) {
        items.add(key);
        heapifyUp();
    }

    abstract void heapifyUp();

    abstract void heapifyDown();

    void swap(int index1, int index2) {
        int tmp = items.get(index1);
        items.set(index1, items.get(index2));
        items.set(index2, tmp);
    }
}

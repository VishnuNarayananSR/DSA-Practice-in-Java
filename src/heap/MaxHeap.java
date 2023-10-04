package heap;

public class MaxHeap extends Heap {
    @Override
    void heapifyUp() {
        int index = getSize() - 1;
        while (hasParent(index) && parent(index) < items.get(index)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    @Override
    void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int biggerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                biggerChildIndex = rightChildIndex(index);
            }
            if (items.get(biggerChildIndex) > items.get(index)) {
                swap(biggerChildIndex, index);
            } else {
                break;
            }
            index = biggerChildIndex;
        }
    }
}

package heap;

public class MinHeap extends Heap {

    @Override
    void heapifyUp() {
        int index = getSize() - 1;
        while (hasParent(index) && parent(index) > items.get(index)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    @Override
    void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = rightChildIndex(index);
            }
            if (items.get(smallerChildIndex) < items.get(index)) {
                swap(index, smallerChildIndex);
            } else {
                break;
            }
            index = smallerChildIndex;
        }
    }
}

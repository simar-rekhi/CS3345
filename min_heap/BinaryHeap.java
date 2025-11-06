


public class BinaryHeap<T extends Comparable<? super T>> {
    private T[] array;
    private int currentSize;

    //binary heap insertion routine
    public void insert (T x) {
        if (currentSize == array.length - 1) {
            expand(array.length * 2 + 1);
        }

        // first insert at the first empty space available in array
        int vacant = ++currentSize;

        // begin percolation - every time compare child and parent
        for(vacant = x; x.compareTo(array[vacant/2]) < 0; vacant /= 2) {
            array[vacant] = array[vacant/2];
            array[vacant/2] = x;
        }
    }

    //binary heap delete min routine
    public T deleteMin() {
        if (currentSize < 1) {
            throw new IllegalStateException("Heap is empty");
        }

        // save min item to return later
        T value = array[1];

        // replace root node value with last element in list value
        array[1] = array[currentSize--];

        // begin downward percolation after comparing parent and child nodes
        int node = 1;
        while (node * 2 <= currentSize) {
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;
            
            // Find the smaller child
            int smallerChild = leftChild;  // Assume left is smaller
            
            // Check if right child exists and is smaller than left child
            if (rightChild <= currentSize && 
                array[rightChild].compareTo(array[leftChild]) < 0) {
                smallerChild = rightChild;
            }

            // Compare parent with smaller child
            if (array[node].compareTo(array[smallerChild]) > 0) {
                // swap and percolate down
                T temp = array[node];
                array[node] = array[min_index];
                array[min_index] = temp;
                node = min_index;
            }

            else {
                break;
            }
        }

        return value;
    }

    // Some notes



}
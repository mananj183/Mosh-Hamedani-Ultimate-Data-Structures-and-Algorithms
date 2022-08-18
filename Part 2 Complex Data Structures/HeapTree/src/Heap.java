import java.util.*;

public class Heap {

    public int[] items = new int[10];
    private int count = 0;

    public void insert(int item){
        if (count >= items.length)
            throw new IllegalStateException();
        items[count++] = item;
        int itemIndex = count-1;
        bubbleUp(itemIndex);
    }
    public boolean isMaxHeap(int[] arr){
        for (int i=0; i<arr.length; i++){
            if(!isMaxHeap(arr, i))
                return false;
        }
        return true;
    }
    private boolean isMaxHeap(int[] arr, int i){
        int left = i*2+1;
        if (left>=arr.length)
            return true;
        int right = i*2+2;
        if (right>=arr.length)
            return arr[i] > arr[left];
        return arr[i] > arr[left] && arr[i]>arr[right];
    }
    public int remove(){
        if (count == 0)
            throw new IllegalStateException();
        int value = items[0];
        items[0] = items[count-1];
        items[--count] = 0;
        bubbleDown(0);
        return value;
    }
    public int[] heapify(int[] arr){
        for(int i:arr){
            insert(i);
        }
        arr = Arrays.copyOfRange(items, 0, count);
        return arr;
    }
    public void print(){
        System.out.println(Arrays.toString(items));
    }
    private void bubbleDown(int index){
        while (index<=count && !isValidParent(index)){
            int largerChildIndex = largerChildIndex(index);
            swapChildWithParent(largerChildIndex, index);
            index = largerChildIndex;
        }
    }
    private int largerChildIndex(int index){
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);
        return leftChild(index)>rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
        if (!hasLeftChild(index))
            return true;
        else if (!hasRightChild(index)) {
            return items[index] >= leftChildIndex(index);
        }
        return items[index] >= leftChild(index) && items[index] >= rightChild(index);
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= count;
    }
    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= count;
    }
    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }
    private int leftChildIndex(int index){
        return (index*2)+1;
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int rightChildIndex(int index){
        return (index*2)+2;
    }

    private void bubbleUp(int index){
        while (index > 0 && items[index] > items[parentIndex(index)]){
            swapChildWithParent(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void swapChildWithParent(int childIndex, int parentIndex){
        int temp = items[childIndex];
        items[childIndex] = items[parentIndex];
        items[parentIndex] = temp;
    }

    private int parentIndex(int i){
        return (i-1)/2;
    }
}

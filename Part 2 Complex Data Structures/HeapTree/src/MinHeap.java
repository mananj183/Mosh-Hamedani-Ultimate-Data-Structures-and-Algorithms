import java.util.HashSet;
import java.util.Set;

public class MinHeap {
    private class Node{
        int key;
        String val;
        public Node(int key, String val){
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString(){
            return "k " + key + " " + "val " + val;
        }
    }
    private Node[] items = new Node[10];
    private int count = 0;
    private Set<Integer> keys = new HashSet<>();

    public void insert(int key, String value){
        if (keys.contains(key))
            throw new IllegalStateException();
        Node n = new Node(key,value);
        keys.add(key);
        items[count++] = n;
        int index = count-1;
        bubbleUp(index);
    }
    private void bubbleUp(int index){
        while(index > 0 && items[index].key < items[parentIndex(index)].key){
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public String remove(){
        String top = items[0].val;
        keys.remove(items[0].key);
        items[0] = items[count-1];
        items[--count] = null;
        bubbleDown(0);
        return top;
    }
    private void bubbleDown(int index){
        int smallerChildIndex = index;

        int leftChildIndex = index*2+1;
        if (leftChildIndex<count && items[leftChildIndex].key<items[smallerChildIndex].key)
            smallerChildIndex = leftChildIndex;

        int rightChildIndex = index*2+2;
        if (rightChildIndex<count && items[rightChildIndex].key < items[smallerChildIndex].key){
            smallerChildIndex = rightChildIndex;
        }

        if(index==smallerChildIndex)
            return;
        swap(index,smallerChildIndex);
        bubbleDown(smallerChildIndex);
    }

    public String getMin(){
        return items[0].val;
    }

    public boolean isEmpty(){
        return count==0;
    }
    private int parentIndex(int index){
        return (index-1)/2;
    }
    private void swap(int first, int second){
        Node temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}

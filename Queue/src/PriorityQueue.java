import java.util.Arrays;
import java.util.Collections;

public class PriorityQueue {
    private Integer[] items = new Integer[5];
    private int count = 0;

    public void add(int item){
        if (isFull()){
            Integer[] tempArr = new Integer[items.length + 5];
            for (int i=0; i<count; i++)
                tempArr[i] = items[i];
            items = tempArr;
        }

        int i;
        for (i = count-1; i>=0; i--){
            if (items[i]>item)
                items[i+1] = items[i];
            else break;
        }
        items[i+1] = item;
        count++;
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();
        Collections.reverse(Arrays.asList(items));
        int top = items[items.length-1];
        for (int i = items.length-1; i>0; i--){
            items[i] = items[i-1];
        }
        Collections.reverse(Arrays.asList(items));
        count--;
       return top;
    }
    public int peek(){
        return items[0];
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString(){
        Integer [] temp = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(temp);
    }
}

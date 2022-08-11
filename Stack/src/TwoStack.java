import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoStack {
    private int[] arr = new int[10];
    private int count1 = 0;
    private int count2 = 0;

    public void push1(int item){
        if (count1+count2 >= 10)
            throw new StackOverflowError();
        arr[count1++] = item;
    }
    public void push2(int item){
        if (count1+count2 >= 10)
            throw new StackOverflowError();
        arr[10-(count2+1)] = item;
        count2++;
    }

    public int pop1(){
        if (isEmpty1())
            throw new IllegalStateException();
        return arr[--count1];
    }

    public int pop2(){
        if (isEmpty2())
            throw new IllegalStateException();
        int top = arr[10-count2];
        count2--;
        return top;
    }

    public String toString1(){
        int[] content = Arrays.copyOfRange(arr,0,count1);
        return Arrays.toString(content);
    }
    public String toString2(){
        int[] content = Arrays.copyOfRange(arr, 10-count2, 10);
        return Arrays.toString(content);
    }
    public boolean isEmpty1(){
        return count1==0;
    }
    public boolean isEmpty2(){
        return count2==0;
    }
    public void print(){
        System.out.println(Arrays.toString(arr));
    }
}

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int count = 0;

    // Latest element added always remains on top of the Queue q1 bcz of swapping
    public void push(int item){
        q2.add(item);
        while (!q1.isEmpty())
            q2.add(q1.remove());
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        count++;
    }

    public int pop(){
        if (isEmpty())
            throw new IllegalStateException();
        count--;
        return q1.remove();
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();
        return q1.peek();
    }

    public boolean isEmpty(){
        return q1.isEmpty();
    }

    public int size(){
        return count;
    }

}

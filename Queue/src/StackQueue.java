import java.util.Stack;

public class StackQueue {
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();

    public void enqueue(int item){
        st1.push(item);
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();

        move_st1_to_st2();
        return st2.pop();
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();

        move_st1_to_st2();
        return st2.peek();
    }

    private void move_st1_to_st2() {
        if (st2.isEmpty())
            while (!st1.isEmpty())
                st2.push(st1.pop());
    }

    public boolean isEmpty(){
        return st1.isEmpty() && st2.isEmpty();
    }
}

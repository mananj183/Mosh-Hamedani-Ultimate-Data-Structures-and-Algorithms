public class ArrayQueue {
    private int[] items;
    public ArrayQueue(int capacity){
        items = new int[capacity];
    }
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public void enqueue(int item){
        if (isFull())
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear+1)%items.length;
        count++;
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();
        int top = items[front];
        items[front] = 0;
        front = (front+1)%items.length;
        count--;
        return top;
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();
        return items[front];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

}

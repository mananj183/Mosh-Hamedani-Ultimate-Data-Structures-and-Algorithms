public class LinkedListQueue {
    private class QNode{
        private int value;
        private QNode next;
        public QNode(int value){
            this.value = value;
        }
    }

    private QNode front;
    private QNode rear;
    private int size = 0;

    public void enqueue(int item){
        QNode qnode = new QNode(item);
        if (isEmpty()){
            front = rear = qnode;
        }else {
            rear.next = qnode;
            rear = qnode;
        }
        size++;
    }

    public int dequeue(){
        int top = 0;
        if (isEmpty())
            throw new IllegalStateException();
        if (front == rear){
            top = front.value;
            front = rear = null;
        }
        else {
            top = front.value;
            QNode second = front.next;
            front.next = null;
            front = second;
        }
        size--;
        return top;
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();
        return front.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return front == null;
    }
}

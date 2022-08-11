import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size = 0;

    public void addLast(int item) {
        Node node = new Node(item);
        if(isEmpty())
            head = tail = node;
        else{
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        Node current = head;
        while(current != null){
            if(current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();
        if(head == tail)
            head = tail = null;
        else {
            Node second = head.next;
            head.next = null;
            head = second;
        }
        size--;
    }

    public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();
        if(head == tail){
            head = tail = null;
        }
        else {
            Node previousNode = getPreviousNode(tail);
            tail = previousNode;
            tail.next = null;
        }
        size--;
    }

    public int[] toArray(){
        int[] array = new int[size];
        int index = 0;
        Node current = head;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverseList(){
        if(isEmpty()){
            return;
        }
        Node previous = head;
        Node current = previous.next;
        while(current!= null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next = null;
        Node temp = head;
        head = tail;
        tail= temp;
    }

    public int kthNodeFromEnd(int k){
        if (isEmpty())
            throw new IllegalStateException("The List is empty");
//        if (k>size)
//            throw new IllegalArgumentException();
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i<k-1; i++){
            p2 = p2.next;
            if (p2==null)
                throw new IllegalArgumentException("value of k is greater than size of linked list");
        }
        while (p2!=tail){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.value;
    }

    public int size(){
        return size;
    }

    public void findMiddle(){
        if (isEmpty())
            throw new IllegalStateException();
        Node p1 = head;
        Node p2 = head;
        while (p2!=tail && p2.next!=tail){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2.next == tail){
            System.out.println(p1.value);
            System.out.println(p1.next.value);
        }else if (p2 == tail){
            System.out.println(p1.value);
        }
    }

    public boolean hasLoop(){
        if (isEmpty())
            throw new IllegalStateException();
        Node p1 = head;
        Node p2 = head;
        while (p2!=null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1==p2)
                return true;
        }
        return false;
    }

    public void addLoop(){
        if(size>=3)
            tail.next = head.next.next;
        else
            System.out.println("Cannot add loop");
    }
    private Node getPreviousNode(Node node) {
        Node current = head;
        while (current != null) {
            if (current.next == tail)
                return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty(){
        return head == null;
    }
}

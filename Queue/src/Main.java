import StackUsingTwoQueue.StackUsingTwoQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        pq.add(5);
        pq.add(2);
        pq.add(1);
        pq.add(4);
        System.out.println(pq.remove());
        pq.add(10);
//        System.out.println(pq.remove());
//        pq.remove();
//        pq.remove();
        pq.add(20);
//        pq.add(2);
        pq.add(3);
        System.out.println(pq.remove());
        System.out.println(pq.peek());
//        System.out.println(pq.remove());
        System.out.println(pq.toString());
//        StackUsingTwoQueues st = new StackUsingTwoQueues();
//        st.push(10);
//        st.push(20);
//        st.push(30);
//        System.out.println(st.peek());
//        System.out.println(st.pop());
//        System.out.println(st.peek());
//        System.out.println(st.pop());


//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(5);
//        pq.add(2);
//        pq.add(1);
//        pq.add(4);
//        pq.add(6);
//        while (!pq.isEmpty())
//            System.out.println(pq.remove());
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        queue.add(40);
//        queue.add(50);
//        reverse(2  , queue);
//        System.out.println(queue);
//        reverse(queue);
//        System.out.println(queue);
    }
//    public static void reverse(Queue<Integer> q){
//        Stack<Integer> st = new Stack<>();
//
//        while (!q.isEmpty())
//            st.push(q.remove());
//        while (!st.isEmpty())
//            q.add(st.pop());
//    }
    public static void reverse(int k, Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
//        int count = 0;
//        while (!q.isEmpty()){
//            if (count<k){
//                st.push(q.remove());
//            }else {
//                temp.add(q.remove());
//            }
//            count++;
//        }
//        for (int i =0; i<count; i++){
//            if (!st.isEmpty())
//                q.add(st.pop());
//            else q.add(temp.remove());
//        }
        for (int i =0; i<k; i++){
            st.push(q.remove());
        }
        int qsize = q.size();
        for (int i=0;i<qsize+k;i++){
            if (i<k)
                q.add(st.pop());
            else q.add(q.remove());
        }

    }

}

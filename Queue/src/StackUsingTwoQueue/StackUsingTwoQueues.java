package StackUsingTwoQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int count = 0;

    public void push(int item){
        q1.add(item);
        count++;
    }

    public int pop(){
        int last = 0;
        int qsize = q1.size();
        if (q2.isEmpty())
            for (int i = 0; i<qsize; i++){
                last = q1.remove();
                if (i<qsize-1)
                    q2.add(last);
            }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return last;
    }

    public int peek(){
        int last = 0;
        int qsize = q1.size();
        if (q2.isEmpty())
            for (int i = 0; i<qsize; i++){
                last = q1.remove();
                q2.add(last);
            }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return last;
    }
}

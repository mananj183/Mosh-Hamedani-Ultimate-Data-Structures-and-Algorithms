import java.util.Stack;

public class MinOfStack {
    private Stack<Integer> st = new Stack<>();
    private int minValue = 0;
    public void push(int item){
        if (st.empty()){
            st.push(item);
            minValue = item;
        }
        else{
            if (item>=minValue){
                st.push(item);
            }
            else {
                st.push(2*item-minValue);
                minValue = item;
            }
        }

    }
    public int pop(){
        int top = 0;
        if (st.empty()){
            throw new IllegalStateException();
        }
        else {
            if (st.peek()>=minValue) {
                top = st.pop();
            }
            else if (st.peek()<minValue) {
                top = st.pop();
                minValue = 2*minValue-top;
            }
        }
        return top;
    }
    public int peek(){
        if (st.empty()){
            throw new IllegalStateException();
        }
        else {
            if (st.peek()>=minValue){
                return st.peek();
            }
            else {
                return minValue;
            }
        }
    }
    public int getMin(){
        return minValue;
    }
    public void print(){

        while (!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}

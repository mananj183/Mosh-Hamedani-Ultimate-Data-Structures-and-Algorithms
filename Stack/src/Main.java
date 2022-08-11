import java.util.Stack;

public class Main {
    public static void main(String[] args){
//        StringReverser strReverser = new StringReverser("abcd");
//        System.out.println(strReverser.reverseString());
//        Expression exp = new Expression("(1-(234)+{23}-<2323(0)>[])");
//        System.out.println(exp.isBalanced());
//        TwoStack twoStack = new TwoStack();
//        twoStack.push2(1);
//        twoStack.push1(2);
//        twoStack.push2(3);
//        twoStack.push1(4);
//        twoStack.push1(5);
//        twoStack.push1(6);
//        twoStack.push2(7);
//        twoStack.push1(8);
//        twoStack.push2(9);
//        twoStack.push1(10);
//        twoStack.pop2();
//        twoStack.push2(10);
//        twoStack.print();
//        System.out.println(twoStack.toString2());
        MinOfStack st = new MinOfStack();
        st.push(5);
        st.push(2);
        st.push(10);
        st.push(1);
//        st.push(9);
        System.out.println(st.getMin());
        st.pop();
//        st.pop();
        System.out.println(st.getMin());
    }
}

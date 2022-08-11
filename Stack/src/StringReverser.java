import java.util.Stack;

public class StringReverser {
    String str;
    public StringReverser(String str){
        this.str = str;
    }
    public String reverseString(){
        Stack<Character> stack = new Stack<>();
        StringBuffer reverse = new StringBuffer();
        for (char c: str.toCharArray()){
            stack.push(c);
        }
        while (!stack.isEmpty()){
            reverse.append(stack.pop());
        }
        return reverse.toString();
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    String expression;
    public Expression(String expression){
        this.expression = expression;
    }
    private final List<Character> leftBrackets =
            Arrays.asList('(', '{', '[', '<');
    private final List<Character> rightBrackets =
            Arrays.asList(')', '}', ']', '>');
     public boolean isBalanced(){
         Stack<Character> stack = new Stack<>();
         for (char ch : expression.toCharArray()){
             if (isLeftBracket(ch))
                 stack.push(ch);
             if (isRightBracket(ch)){
                 if (stack.isEmpty())
                     return false;

                 char top = stack.pop();
                 if (!bracketsMatch(top, ch))
                     return false;
             }
         }
         return true;
     }

     private boolean isLeftBracket(char ch){
         return leftBrackets.contains(ch);
     }
     private boolean isRightBracket(char ch){
         return rightBrackets.contains(ch);
     }
     private boolean bracketsMatch(char leftBracket, char rightBracket){
         return leftBrackets.indexOf(leftBracket) == rightBrackets.indexOf(rightBracket);
     }
}

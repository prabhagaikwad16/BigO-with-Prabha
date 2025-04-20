package e_Stack;

import java.util.Stack;

public class c_CheckedBalanced_Parentheses {

    public static void main(String[] args) {

        String s = "[{[()]}]([]){}";
        c_CheckedBalanced_Parentheses checkedBalancedParentheses = new c_CheckedBalanced_Parentheses();
        boolean balancedParentheses = checkedBalancedParentheses.isValid(s);
        System.out.println(balancedParentheses);
    }

    public boolean isValid(String s) {

        //preserver every opening parentheses on stack and pop for new closing parentheses and check if they are matching.
        Stack<Character> stack = new Stack<Character>();

        for(int i =0;i< s.length();i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else if(c == '}' || c == ']' || c == ')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    char top = stack.pop();
                    if((!((c=='}' && top == '{') ||
                            (c==']' && top == '[') ||
                                (c==')' && top == '(')))){
                        return false;
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    //Most efficient
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}

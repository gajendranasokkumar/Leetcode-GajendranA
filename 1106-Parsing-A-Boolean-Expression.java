class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for(char i : expression.toCharArray()) {
            if(i != ',')
                stack.push(i);            

            char top = stack.peek();
            if(top == ')') {
                int tr = 0, fl = 0;
                stack.pop();
                while(stack.peek() != '(') {
                    char one = stack.pop();
                    if(one == 't')
                        tr++;
                    else 
                        fl++;
                }
                stack.pop();
                char oper = stack.pop();

                if(oper == '&') {
                    if(fl != 0)
                        stack.push('f');
                    else
                        stack.push('t');
                } 
                else if(oper == '|') {
                    if(tr == 0)
                        stack.push('f');
                    else
                        stack.push('t');
                }
                else if(oper == '!') {
                    if(tr == 0 && fl != 0)
                        stack.push('t');
                    else
                        stack.push('f');
                }
            }

        }

        return stack.peek() == 't' ? true : false;
    }
}
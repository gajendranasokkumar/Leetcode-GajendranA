class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ')') {
                int tr = 0, fl = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') 
                        tr++;
                    else if (val == 'f') 
                        fl++;
                }
                stack.pop();
                char operator = stack.pop();
                
                if (operator == '&') 
                    stack.push(fl > 0 ? 'f' : 't');
                else if (operator == '|') 
                    stack.push(tr > 0 ? 't' : 'f');
                else if (operator == '!') 
                    stack.push(fl > 0 ? 't' : 'f');
            
            } else if (ch != ',') {
                stack.push(ch);
            }
        }

        return stack.pop() == 't';
    }
}

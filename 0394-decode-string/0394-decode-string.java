class Solution {
    public String decodeString(String s) {
        Stack<String> stack  = new Stack<>();
        String num = "";
        for(char j: s.toCharArray()) {
            String i = String.valueOf(j);
            if(i.equals("]")) {
                String str = "";

                while(!stack.isEmpty() && !stack.peek().equals("[")) 
                    str = stack.pop() + str;
                stack.pop();

                int n = Integer.parseInt(stack.pop());

                String newstr = "";
                while(n-- > 0) 
                    newstr += str;

                stack.push(newstr); 
            } else if(i.equals("[")){
                stack.push(num);
                stack.push("[");
                num = "";
            } else if(j >= 'a' && j <= 'z') {
                stack.push(i);
            } else {
                num += i;
            }
        }

        String result = "";
        while(!stack.isEmpty()) 
            result = stack.pop() + result;

        return result;
    }
}
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String result = "";
        String[] str = path.split("/");
        for(String i: str) {
            if(i.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            } else if(i.length() != 0 && !i.equals(".")) {
                stack.push(i);
            }
        }

        // System.out.println(stack);
        while(!stack.isEmpty()) 
            result = "/" + stack.pop() + result;

        return result.length() == 0 ? "/" : result;
    }
}
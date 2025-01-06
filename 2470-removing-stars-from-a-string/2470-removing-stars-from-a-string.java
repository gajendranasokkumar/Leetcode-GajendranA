class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char i : s.toCharArray()) {
            if(i == '*' && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.push(i);
        }   
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty())
            str.insert(0, stack.pop());
        
        return str.toString();
    }
}
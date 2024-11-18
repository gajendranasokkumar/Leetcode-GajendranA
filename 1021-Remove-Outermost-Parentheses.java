class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int balance = 0;
        
        // Traverse the string
        for (char ch : s.toCharArray()) {
            // If it's an opening parenthesis
            if (ch == '(') {
                // If it's the outermost parenthesis, don't add to result
                if (balance > 0) {
                    res.append(ch);
                }
                balance++;
            } 
            // If it's a closing parenthesis
            else {
                balance--;
                // If it's the outermost parenthesis, don't add to result
                if (balance > 0) {
                    res.append(ch);
                }
            }
        }
        
        return res.toString();
    }
}

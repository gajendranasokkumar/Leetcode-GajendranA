// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack<Character> stack = new Stack<Character>();
//         int count = 0, max = 0;
//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 stack.push(c);
//             } else {
//                 if (stack.isEmpty()) {
//                     count = 0;
//                     continue;
//                 }
//                 char top = stack.peek();
//                 if (c == ')' && top == '(') {
//                     stack.pop();
//                     count += 2;
//                 }
//             }
//             max = Math.max(max, count);
//         }
//         return max;
//     }
// }


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); 
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); 
            } else {
                stack.pop(); 
                if (stack.isEmpty()) {
                    stack.push(i); 
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }

            // System.out.println(stack);
        }
        return max;
    }
}

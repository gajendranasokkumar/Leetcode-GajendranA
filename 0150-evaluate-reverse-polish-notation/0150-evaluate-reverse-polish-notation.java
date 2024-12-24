class Solution {
    public int compute(int i, int j, String op) {
        if(op.equals("+"))
            return i+j;
        else if(op.equals("-"))
            return i-j;
        else if(op.equals("*"))
            return i*j;
        else
            return i/j;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String[] ops = new String[]{"+", "-", "*", "/"};
        Set<String> set = new HashSet<>(Arrays.asList(ops));

        for(String k : tokens) {
            if(set.contains(k)) {
                int j = stack.pop();
                int i = stack.pop();
                int num = compute(i, j, k);
                stack.push(num);
                continue;
            }
            stack.push(Integer.parseInt(k));
        }

        return stack.peek();
    }
}
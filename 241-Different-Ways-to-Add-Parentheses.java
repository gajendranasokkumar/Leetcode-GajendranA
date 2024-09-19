class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
         List<Integer> result = new ArrayList<>();

        // Traverse through the string
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operator
            if (c == '+' || c == '-' || c == '*') {
                // Recursively solve the left and right parts of the expression
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

                // Combine the results of both sides based on the operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else if (c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        // Base case: if no operator is found, the expression is a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}
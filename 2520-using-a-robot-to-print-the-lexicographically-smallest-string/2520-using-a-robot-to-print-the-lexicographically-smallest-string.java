class Solution {
    public String robotWithString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] found = new int[26];
        for(char c : s.toCharArray()) 
            found[c - 'a']++;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            found[idx]--;
            stack.push(c);
            while(!stack.isEmpty()) {
                char ch = stack.peek();
                int index = ch - 'a';

                boolean isSmall = false;
                for(int i=index-1;i>=0;i--) {
                    if(found[i] != 0) {
                        isSmall = true;
                        break;
                    }
                }

                if(isSmall) 
                    break;
                
                sb.append(stack.pop());
            }

        }

        return sb.toString();
    }
}
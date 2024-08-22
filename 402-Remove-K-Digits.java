import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        
        for (char c : num.toCharArray()) {
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > c) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        
        while (k > 0 && !deque.isEmpty()) {
            deque.removeLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : deque) {
            sb.append(c);
        }
        
        String result = sb.toString().replaceFirst("^0+(?!$)", "");
        
        return result.isEmpty() ? "0" : result;
    }
}

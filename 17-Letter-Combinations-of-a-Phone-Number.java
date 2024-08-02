class Solution {
    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
     public void phone(String digits, int index, String one) {
        if (index == digits.length()) {
            result.add(one);
            return;
        }
        
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            phone(digits, index + 1, one + letters.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        map.put('2', \abc\);
        map.put('3', \def\);
        map.put('4', \ghi\);
        map.put('5', \jkl\);
        map.put('6', \mno\);
        map.put('7', \pqrs\);
        map.put('8', \tuv\);
        map.put('9', \wxyz\);
        // phone(digits, 0, digits.length(), \\);
        
        phone(digits, 0, \\);
        return result;
    }
}
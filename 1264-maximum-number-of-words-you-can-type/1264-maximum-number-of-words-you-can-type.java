class Solution {
    public int canBeTypedWords(String text, String broken) {

        Set<Character> bro = new HashSet<>();

        for (char c : broken.toCharArray()) {
            bro.add(c);
        }

        String[] arr = text.split(" ");
        int count = 0;

        for (String word : arr) {

            boolean canType = true;

            for (char ch : word.toCharArray()) {

                if (bro.contains(ch)) {
                    canType = false;
                    break;
                }
            }

            if (canType) {
                count++;
            }
        }
        return count;
    }
}
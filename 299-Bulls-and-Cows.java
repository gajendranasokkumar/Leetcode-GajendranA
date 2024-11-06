class Solution {
    public String getHint(String secret, String guess) {
        int b = 0;
        int c = 0;
        HashMap<Character, Integer> h1 = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                b++;

            }
            else {
                h1.put(secret.charAt(i), h1.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (h1.get(guess.charAt(i)) != null && h1.get(guess.charAt(i)) > 0) {
                    c++;
                    h1.put(guess.charAt(i), h1.get(guess.charAt(i)) - 1);
                }
            }
        }

        StringBuilder s1 = new StringBuilder();
        s1.append(Integer.toString(b));
        s1.append('A');
        s1.append(Integer.toString(c));
        s1.append('B');
        return s1.toString();
    }
}
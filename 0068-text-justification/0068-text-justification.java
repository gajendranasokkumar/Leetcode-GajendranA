class Solution {
    public static List<String> result;
    public static int maxWidth;

    public List<String> fullJustify(String[] words, int maxWidthh) {
        result = new ArrayList<>();
        maxWidth = maxWidthh;
        formLine(words, 0, new StringBuilder(), 0);
        String lastWord = result.get(result.size() - 1);
        result.remove(result.size() - 1);
        alterLast(lastWord);
        return result;
    }

    public static void formLine(String[] words, int idx, StringBuilder cur, int wordCount) {
        if (idx >= words.length) {
            if (cur.length() > 0) {
                addLine(cur, wordCount);
            }
            return;
        }

        String word = words[idx];
        int additionalLength = cur.length() + word.length() + (wordCount > 0 ? 1 : 0);

        if (additionalLength > maxWidth) {
            addLine(cur, wordCount);
            cur.setLength(0);
            formLine(words, idx, cur, 0);
        } else {
            if (cur.length() > 0) cur.append(" ");
            cur.append(word);
            formLine(words, idx + 1, cur, wordCount + 1);
        }
    }

    public static void addLine(StringBuilder cur, int wordCount) {
        int extraSpaces = maxWidth - cur.length();

        if (wordCount == 1 || !cur.toString().contains(" ")) {
            while (cur.length() < maxWidth) {
                cur.append(" ");
            }
        } else {
            String[] words = cur.toString().split(" ");
            int spaceBetween = extraSpaces / (words.length - 1);
            int remainingSpaces = extraSpaces % (words.length - 1);

            cur.setLength(0);
            for (int i = 0; i < words.length; i++) {
                cur.append(words[i]);
                if (i < words.length - 1) {
                    for (int j = 0; j < spaceBetween + 1; j++) cur.append(" ");
                    if (remainingSpaces-- > 0) cur.append(" ");
                }
            }
        }

        result.add(cur.toString());
    }
    public static void alterLast(String lastWord) {
        String[] words = lastWord.split(" ");
        StringBuilder newWord = new StringBuilder();
        for(String i : words)
            if(i.length() != 0)
                newWord.append(i + " ");
            
        int availSpace = maxWidth - newWord.length();
        for(int i=newWord.length();i<maxWidth;i++)
            newWord.append(" ");
        newWord.setLength(maxWidth);

        result.add(newWord.toString());
        
    }
}

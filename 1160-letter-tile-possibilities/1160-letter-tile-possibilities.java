class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr); 
        backtrack(arr, new StringBuilder(), used, set);
        return set.size();
    }

    private void backtrack(char[] tiles, StringBuilder path, boolean[] used, Set<String> set) {
        if (path.length() > 0) {
            set.add(path.toString());
        }
        for (int i = 0; i < tiles.length; i++) {
            if (used[i] || (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            path.append(tiles[i]);
            backtrack(tiles, path, used, set);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }
}

class Solution {
    public int numberOfSubstrings(String s) {
    int[] lastSeen = new int[3];
    lastSeen[0] = lastSeen[1] = lastSeen[2] = -1;
    
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
        lastSeen[s.charAt(i) - 'a'] = i;
        
        count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
    }
    
    return count;
}

}
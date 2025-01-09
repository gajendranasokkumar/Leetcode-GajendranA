class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int len = spells.length;
        int result[] = new int[len];
        for(int i=0;i<len;i++) 
            result[i] = n - findIdx(potions, 0, n-1, success, spells[i]);
        return result;
    }
    public int findIdx(int[] potions, int i, int j, long success, int costs) {
        while(i <= j) {
            int mid = i+(j-i)/2;
            long product = (long) costs * potions[mid];
            if(product >= success)
                j = mid-1;
            else
                i = mid+1;
        }
        return i;
    }
}
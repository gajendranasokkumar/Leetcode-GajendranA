class Solution {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = row.length;
        for (int i = 0; i < n; i++) 
            map.put(row[i], i);
        
        int swaps = 0;
        for (int i = 0; i < n; i += 2) {
            int boy = row[i];
            int expectedPartner = (boy % 2 == 0) ? boy + 1 : boy - 1;
            
            if (row[i + 1] == expectedPartner) 
                continue;
            
            int partnerIdx = map.get(expectedPartner);
            int temp = row[i + 1];
            row[i + 1] = row[partnerIdx];
            row[partnerIdx] = temp;
            
            map.put(row[partnerIdx], partnerIdx);
            map.put(row[i + 1], i + 1);
            
            swaps++;
        }
        return swaps;
    }
}

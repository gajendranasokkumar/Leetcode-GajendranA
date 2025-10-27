class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        if(n == 0)
            return 0;
        
        int initones = 0, i = 0;
        for(i=0; i<n; i++) {
            initones = totalNums(bank[i]);
            if(initones != 0){
                i++;
                break;
            }
        }
        int ans = 0, curones = 0;
        for(; i<n; i++) {
            String str = bank[i];
            curones = totalNums(str);
            if(curones == 0)
                continue;
            ans += initones * curones;
            // System.out.println(initones + " " + curones);
            initones = curones;
        }
        return ans;
    }
    public int totalNums(String str) {
        int count = 0;
        for(char c : str.toCharArray())
            if(c == '1')
                count++;
        return count;
    }
}
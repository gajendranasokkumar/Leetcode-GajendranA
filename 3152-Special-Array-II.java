class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] mark = new int[len];
        int[] temp = new int[len];
        for(int i=0;i<len;i++) {
            mark[i] = nums[i]%2==0 ? 0 : 1;
            
            if(i == 0)
                continue;
            
            if(mark[i] == mark[i-1])
                temp[i] = temp[i-1] + 1;
            else
                temp[i] = temp[i-1];
        }

        boolean[] result = new boolean[queries.length];
        for(int i=0;i<queries.length;i++) {
            result[i] = (temp[queries[i][1]] - temp[queries[i][0]] == 0) ? true : false; 
        }

        return result;
    }
}
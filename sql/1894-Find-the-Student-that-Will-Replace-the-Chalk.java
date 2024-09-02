class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int i=0;
        for(int j: chalk)
            sum+=j;
        while(k >= sum)
            k -= sum;
        if(k > 0)
            for(i=0;i<chalk.length;i++)
                if(k >= chalk[i])
                    k -= chalk[i];
                else
                    break;
        return i;
    }
}
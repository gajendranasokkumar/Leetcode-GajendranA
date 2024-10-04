class Solution {
    public long dividePlayers(int[] skill) {
        int[] map = new int[1001];
        long sum = 0;
        long total = 0;
        int teamCount = skill.length / 2;
        for(int i: skill)
        {
            sum += i;
            map[i]++;
        }
        long add = sum / teamCount;
        if(sum % teamCount != 0)
            return -1;
        for(int i=0;i<skill.length;i++)
        {  
            if(map[skill[i]]>0){
                int rem = (int) add - skill[i];
                if(map[rem] <= 0)
                    return -1;
                total += skill[i] * rem;
                map[rem]--;
                map[skill[i]]--;
            }
        }
        return total;
    }
}
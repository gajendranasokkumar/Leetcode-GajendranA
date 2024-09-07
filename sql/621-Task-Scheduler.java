class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] taskFreq = new int[26];
        for(char c : tasks){
            taskFreq[c-'A']++;
        }
        Arrays.sort(taskFreq);
        int batch = taskFreq[25];
        int vslots = --batch*n;
        for(int i = 0;i<25; i++){
            vslots -= Math.min(taskFreq[i],batch);
        }
        return vslots>0 ? tasks.length+vslots:tasks.length;
    }
}
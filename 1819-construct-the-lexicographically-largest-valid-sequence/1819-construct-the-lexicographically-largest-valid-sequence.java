class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = (n*2)-1;
        int[] ans = new int[size];
        boolean[] visited = new boolean[n+1];
        place(ans, n, visited, 0);
        return ans;
    }
    public boolean place(int[] ans, int n, boolean[] visited, int i) {
        if(i == ans.length)
            return true;
        if(ans[i] != 0)
            return place(ans, n, visited, i+1);
        for(int num=n;num>0;num--) {
            int next = i+num; 
            if(visited[num])
                continue;
            if(num == 1) {
                visited[num] = true;
                ans[i] = num;
                if(place(ans, n, visited, i+1))
                    return true;
                visited[num] = false;
                ans[i] = 0;
            }
            else if(next < ans.length && ans[i] == 0 && ans[next] == 0) {
                visited[num] = true;
                ans[i] = num;
                ans[next] = num;
                if(place(ans, n, visited, i+1))
                    return true;
                visited[num] = false;
                ans[i] = 0;
                ans[next] = 0;
            }
        }
        return false;
    }
}
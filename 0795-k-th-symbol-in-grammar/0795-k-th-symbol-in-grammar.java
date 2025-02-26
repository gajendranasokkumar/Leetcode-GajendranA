class Solution {
    public int kthGrammar(int n, int k) {
        return dfs(0, 1, n, k, 1, (1 << (n - 1)));
    }
    public int dfs(int num, int currow, int n, int k, int start, int end) {
        if(currow == n)
            return num;
        int mid = start + (end - start) / 2;
        if(k <= mid)
            return dfs(num, currow + 1, n, k, start, mid);
        return dfs(num ^ 1, currow + 1, n, k, mid + 1, end);
    }
}

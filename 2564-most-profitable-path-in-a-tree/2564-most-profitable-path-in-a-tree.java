class Solution {
    public int mostProfitablePath(int[][] edges, int bobstart, int[] amount) {
        int n = amount.length;
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            map.add(new ArrayList<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        } 
        int[] bobtiming = new int[n];
        Arrays.fill(bobtiming, Integer.MAX_VALUE);
        bobmove(map, bobstart, -1, bobtiming, 0);
        return alicemove(map, 0, -1, bobtiming, 0, 0, amount);
    }

    public boolean bobmove(List<List<Integer>> map, int from, int par, int[] bobtiming, int now) {
        bobtiming[from] = now;
        if (from == 0) 
            return true;
        for (int to : map.get(from)) {
            if (to != par) {  
                if (bobmove(map, to, from, bobtiming, now + 1)) 
                    return true;
            }
        }
        bobtiming[from] = Integer.MAX_VALUE; 
        return false;
    }

    public int alicemove(List<List<Integer>> map, int from, int par, int[] bobtiming, int now, int money, int[] amount) {
        if (bobtiming[from] == now) 
            money += amount[from] / 2;
        else if (bobtiming[from] > now)
            money += amount[from];

        int maxi = Integer.MIN_VALUE;
        boolean isLeaf = true;
        for (int to : map.get(from)) {
            if (to != par) {  
                isLeaf = false;
                maxi = Math.max(maxi, alicemove(map, to, from, bobtiming, now + 1, money, amount));
            }
        }
        return isLeaf ? money : maxi;
    }
}

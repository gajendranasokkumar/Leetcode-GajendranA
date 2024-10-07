class Solution {
    public int edgeScore(int[] edges) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++) {
            map.putIfAbsent(edges[i], new ArrayList<Integer>());
            map.get(edges[i]).add(i);
        }
        // System.out.println(map);
        long max = -1; int node = 0;
        for(int i=0;i<edges.length;i++) {
            ArrayList<Integer> list = map.getOrDefault(i, new ArrayList<>());
            long sum = 0;
            for(int j=0;j<list.size();j++) {
                sum += list.get(j);
            }
            if(max < sum) {
                max = sum;
                node = i;
            }
        }
        return node;
    }
}
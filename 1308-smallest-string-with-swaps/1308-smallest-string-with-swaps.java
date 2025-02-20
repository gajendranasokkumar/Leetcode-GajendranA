class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<List<Integer>> map = new ArrayList<>();
        List<PriorityQueue<Character>> components = new ArrayList<>();
        int n = s.length();
        for(int i=0;i<n;i++) {
            map.add(new ArrayList<>());
            components.add(new PriorityQueue<>());
        }
        for(List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int[] number = new int[n];
        int componentNumber = 0;
        for(int i=0;i<n;i++)
            if(!visited[i]) {
                dfs(map, i, components, componentNumber, visited, s, number);
                componentNumber++;
            }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++) {
            str.append(components.get(number[i]).poll());
        }
        return str.toString();
    }
    public void dfs(List<List<Integer>> map, int from, List<PriorityQueue<Character>> components, int componentNumber, boolean[] visited, String s, int[] number) {
        if(visited[from])
            return; 
        visited[from] = true;
        number[from] = componentNumber;
        components.get(componentNumber).add(s.charAt(from));
        for(int to : map.get(from))
            dfs(map, to, components, componentNumber, visited, s, number);
    }
}
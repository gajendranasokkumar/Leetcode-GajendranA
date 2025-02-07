class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        findPath(graph, 0, graph.length-1, new ArrayList<>());
        return result;
    }
    public void findPath(int[][] graph, int src, int dest, List<Integer> list) {
        if(src == dest) {
            list.add(dest);
            result.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(src);
        for(int i: graph[src]) {
            findPath(graph, i, dest, list);
        }
        list.remove(list.size() - 1);
    } 
}
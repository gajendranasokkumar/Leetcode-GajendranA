class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Graph graph = new Graph(n);
        for(int i[] : invocations) 
            graph.addEdge(i[0], i[1]);
        graph.markAffected(k);
        // graph.printGraph();
        for(int i=0;i<n;i++) {
            if(!graph.visited[i] && !graph.affected[i])
                if(graph.dfs(i))
                    return graph.getGraph();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<graph.affected.length;i++)
            if(!graph.affected[i])
                list.add(i);
        return list;
    }
}

class Graph {
    public int vertices;
    public LinkedList<Integer>[] adjacencyList;
    public boolean[] affected;
    public boolean[] visited;
    public Graph(int vertices) {
        this.vertices = vertices;
        this.affected = new boolean[vertices];
        this.visited = new boolean[vertices];
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjacencyList[i] = new LinkedList<>();
    }
    public void addEdge(int source, int destination) { 
        adjacencyList[source].add(destination);
    }
    public void printGraph() {
        for(int source=0;source<vertices;source++)
            System.out.println(source + " -> " + adjacencyList[source]);
        System.out.println(Arrays.toString(affected));    
    }
    public ArrayList<Integer> getGraph() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int source=0;source<vertices;source++)
            list.add(source);
        return list;
    }
    public void markAffected(int source) {
        LinkedList<Integer> list = adjacencyList[source];
        if(affected[source])
            return;
        affected[source] = true;
        for(int i=0;i<list.size();i++) {
            int num = list.get(i);
            markAffected(num);
        }
    }
    public boolean dfs(int source) {
        if(affected[source]) 
            return true;
        if(visited[source])
            return false;
        visited[source] = true;
        LinkedList<Integer> list = adjacencyList[source];
        for(int i=0;i<list.size();i++) {
            if(dfs(list.get(i)))   
                return true;
        }

        return false;
    }
}
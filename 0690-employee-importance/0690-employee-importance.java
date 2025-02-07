/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int imps=0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(Employee e : employees) 
            map.put(e.id, idx++);
        boolean[] visited = new boolean[idx];
        dfs(employees, map.get(id), visited, map);
        return imps;
    }
    public void dfs(List<Employee> emp, int src, boolean[] visited, Map<Integer, Integer> map) {
        if(visited[src])
            return;
        visited[src] = true;
        imps += emp.get(src).importance;
        for(int id : emp.get(src).subordinates)
            dfs(emp, map.get(id), visited, map);
    }
}
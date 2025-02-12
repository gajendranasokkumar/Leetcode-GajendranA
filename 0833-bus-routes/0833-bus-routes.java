class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) 
            return 0; 

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        int n = routes.length;

        for (int bus = 0; bus < n; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.putIfAbsent(stop, new ArrayList<>());
                stopToBuses.get(stop).add(bus);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();

        if (!stopToBuses.containsKey(source)) 
            return -1;

        for (int bus : stopToBuses.get(source)) {
            queue.add(bus);
            visitedBuses.add(bus);
        }

        int busCount = 1; 

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int bus = queue.poll();
                for (int stop : routes[bus]) {
                    if (stop == target)
                        return busCount;

                    if (visitedStops.contains(stop)) continue;
                    visitedStops.add(stop);

                    for (int nextBus : stopToBuses.get(stop)) {
                        if (!visitedBuses.contains(nextBus)) {
                            queue.add(nextBus);
                            visitedBuses.add(nextBus);
                        }
                    }
                }
            }
            busCount++;
        }

        return -1; 
    }
}

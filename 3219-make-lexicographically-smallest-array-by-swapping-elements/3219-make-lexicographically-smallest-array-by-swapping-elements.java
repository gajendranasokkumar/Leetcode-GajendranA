class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = new int[n];
        System.arraycopy(nums, 0, arr, 0, n);
        Arrays.sort(arr);
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for(int i : arr) {
            parent.put(i, i);
        }
        for(int i=0;i<n-1;i++) {
            if(Math.abs(arr[i] - arr[i+1]) <= limit) {
                int ul_a = parent.get(arr[i]);
                parent.put(arr[i+1], ul_a);
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(ul_a).add(arr[i+1]);
            }
        }
        // Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        // while (iterator.hasNext()) {
        //     Map.Entry<Integer, List<Integer>> entry = iterator.next();
        //     if (entry.getValue().isEmpty()) { 
        //         iterator.remove(); 
        //     }
        // }

        int idx = 0;
        while(idx < n) {
            int ul_a = parent.get(nums[idx]);
            if(!visited.contains(ul_a)) {
                arr[idx] = ul_a;
                visited.add(ul_a);
            } else {
                int next = map.get(ul_a).get(0);
                map.get(ul_a).remove(0);
                if(map.get(ul_a).size() == 0)
                    map.remove(ul_a);
                arr[idx] = next;
                visited.add(next);
            }
            idx++;
        }

        return arr;

    }
}
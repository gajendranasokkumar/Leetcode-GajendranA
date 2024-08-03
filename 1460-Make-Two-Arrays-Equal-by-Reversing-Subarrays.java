class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<target.length;i++)
        {
            map.put(target[i], map.getOrDefault(target[i], 0) + 1);
        }

        System.out.println(map);

        for(int i=0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]))
                return false;
            
            map.put(arr[i] , map.get(arr[i]) - 1);
        }

        System.out.println(map);

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if(entry.getValue() != 0)
                return false;
        }

        return true;
    }
}
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String result = "";
        for(String i: arr)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            if(entry.getValue() == 1)
            {
                k--;
                if(k == 0)
                {
                    result = entry.getKey();
                    break;
                }
            }
        }
        return result;
    }
}
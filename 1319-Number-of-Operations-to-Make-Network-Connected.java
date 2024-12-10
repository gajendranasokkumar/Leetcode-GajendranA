class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mp  = new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Collection<Integer> values = mp.values();        
        // List<Integer> a = new ArrayList<>(mp.values());
        // Collections.sort(a);
        // System.out.println(a);
        // int var = a.get(0);
        // for(int i=1;i<a.size();i++)
        // {
        //     if(a.get(i) == var )
        //     {
        //         System.out.println(\Comming\);
        //         return false;
        //     }
        //     var = a.get(i);
                
        // }
        // return true;

        Set<Integer> sp=new HashSet<>();
        for (Map.Entry<Integer, Integer> me : mp.entrySet()) 
        { 
            if(sp.contains(me.getValue()))
            {
                return(false);
            }
            else
            {
                sp.add(me.getValue());
            }
        }
        return(true);
    }
}
class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char i: word.toCharArray())
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int len = map.size(), count=0;
        OneLetter[] arr = new OneLetter[len];
        int a=0;
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            arr[a++] = new OneLetter(entry.getKey(), entry.getValue());
        }
        Arrays.sort(arr, (x,y) -> y.n - x.n);
        // for(OneLetter x:arr)
        // {
        //     System.out.println(x.toString());
        // }
        int minpush=0, pointer=0;
        for(int i=1;i<=4;i++)
        {
            count=0;
            while (count<8 && pointer<arr.length)
            {
                minpush += i * arr[pointer++].n;
                count++;
            }
        }
        return minpush;
    }
}

class OneLetter{
    char l;
    int n;
    public OneLetter(char a, int b)
    {
        l = a;
        n = b;
    }
    public String toString()
    {
        return "{ "+l+", "+n+" }";
    }
}
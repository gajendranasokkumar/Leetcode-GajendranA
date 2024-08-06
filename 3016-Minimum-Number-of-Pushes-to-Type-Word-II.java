class Solution {
    // public int minimumPushes(String word) {
    //     Map<Character, Integer> map = new HashMap<>();
    //     for(char i: word.toCharArray())
    //     {
    //         map.put(i, map.getOrDefault(i, 0) + 1);
    //     }
    //     int len = map.size(), count=0;
    //     OneLetter[] arr = new OneLetter[len];
    //     int a=0;
    //     for(Map.Entry<Character, Integer> entry : map.entrySet())
    //     {
    //         arr[a++] = new OneLetter(entry.getKey(), entry.getValue());
    //     }
    //     Arrays.sort(arr, (x,y) -> y.n - x.n);
    //     // for(OneLetter x:arr)
    //     // {
    //     //     System.out.println(x.toString());
    //     // }
    //     int minpush=0, pointer=0;
    //     for(int i=1;i<=4;i++)
    //     {
    //         count=0;
    //         while (count<8 && pointer<arr.length)
    //         {
    //             minpush += i * arr[pointer++].n;
    //             count++;
    //         }
    //     }
    //     return minpush;
    // }
    public int minimumPushes(String word){
        Integer[] arr = new Integer[26];
        Arrays.fill(arr, 0);
        for(char i: word.toCharArray())
        {
            arr[i-'a']++;
        }
        Arrays.sort(arr, Comparator.comparingInt((Integer a) -> a).reversed());
        int num=0, minpush = 0, inc = 1;
        for(int i=0;i<26;i++)
        {
            if(arr[i] == 0)
                break;

            num++;
            minpush += inc * arr[i];

            if(num==8)
            {
                num = 0;
                inc++;
            }
        }
        return minpush;
    }
}

// class OneLetter{
//     char l;
//     int n;
//     public OneLetter(char a, int b)
//     {
//         l = a;
//         n = b;
//     }
//     public String toString()
//     {
//         return "{ "+l+", "+n+" }";
//     }
// }
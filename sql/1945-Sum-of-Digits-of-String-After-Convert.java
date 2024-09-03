class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for(char i: s.toCharArray())
        {
            list.add(i - 96);
        }
        for(int i: list)
        {
            int n = i;
            while(n > 0)
            {
                num += n%10;
                n /= 10;
            }
        }
        k--;
        while(k-- > 0)
        {
            int n = 0;
            while(num > 0)
            {
                n += num%10;
                num /= 10;
            }
            num = n;
        }
        return num;
    }
}
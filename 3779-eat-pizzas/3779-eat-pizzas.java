class Solution {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        int numdays = n / 4;
        Arrays.sort(pizzas);

        long sum = 0;
        int even = numdays / 2;
        int odd = numdays - even;
        int i = n - 1;
        while (i >= 0 && odd > 0) {
            sum += pizzas[i];
            i--;
            odd--;
        }
        while (i >= 1 && even > 0) {
            sum += pizzas[i-1];
            i-=2; 
            even--;
        }
        return sum;
    }
}

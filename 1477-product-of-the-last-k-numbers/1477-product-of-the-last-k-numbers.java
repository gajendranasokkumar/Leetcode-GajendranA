class ProductOfNumbers {
    List<Integer> list;
    int n;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
        n = 0;
    }
    
    public void add(int num) {
        if(num == 0) {
            n = 0;
            list.clear();
            list.add(1);
        } else {
            list.add(list.get(n) * num);
            n++;
        }
    }
    
    public int getProduct(int k) {
        if(k > n)
            return 0;
        return list.get(n) / list.get(n-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        Pair newpair = new Pair(price, 1);
        while(!stack.empty() && stack.peek().price <= newpair.price)
        {
            newpair.count += stack.peek().count;
            stack.pop();
        }
        stack.push(newpair);
        return newpair.count;
    }
}

class Pair{
    int price;
    int count;
    public Pair(int n, int c)
    {
        this.price = n;
        this.count = c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
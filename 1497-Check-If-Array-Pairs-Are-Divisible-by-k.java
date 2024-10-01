class CustomStack {
    private int[] stack;
    private int[] increment;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.top = -1;
    }
    
    public void push(int x) {
        if (top < maxSize - 1) {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int result = stack[top] + increment[top];
        if (top > 0) {
            increment[top - 1] += increment[top];
        }
        increment[top] = 0;
        top--;
        return result;
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k - 1, top);
        if (limit >= 0) {
            increment[limit] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
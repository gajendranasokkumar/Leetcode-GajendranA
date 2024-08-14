class MyQueue {

    Stack <Integer> myStack;
    Stack<Integer> queueOfStack;

    public MyQueue() {
        
        myStack = new Stack<>();
        queueOfStack = new Stack<>();

    }
    
    public void push(int x) {


        while(!myStack.isEmpty())
        {
            queueOfStack.push(myStack.pop());
        }

        myStack.push(x);


         while(!queueOfStack.isEmpty())
        {
            myStack.push(queueOfStack.pop());
        }
        
    }
    
    public int pop() {

        return myStack.pop();
        
    }
    
    public int peek() {
        
        return myStack.peek();
    }
    
    public boolean empty() {
        return myStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
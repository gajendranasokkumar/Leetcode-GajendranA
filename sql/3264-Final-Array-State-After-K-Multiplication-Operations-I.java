class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Numberss> queue = new PriorityQueue<Numberss>();
        for(int i=0;i<nums.length;i++)
        {
            queue.add(new Numberss(nums[i], i));
        }
        while(!queue.isEmpty() && k-- > 0)
        {
            Numberss firstElement = queue.poll();
            firstElement.num = firstElement.num * multiplier;  
            queue.add(firstElement);
        }
        while (!queue.isEmpty()) {
            Numberss n = queue.poll();
            nums[n.index] = n.num;
            // System.out.println("num: " + n.num + ", index: " + n.index);
        }
        return nums;
    }
}

class Numberss implements Comparable<Numberss> {
    public int num;
    public int index;
    public Numberss(int n, int i)
    {
        this.num = n;
        this.index = i;
    }
    @Override
    public int compareTo(Numberss other) {
        if (this.num != other.num) {
            return Integer.compare(this.num, other.num);
        } else {
            return Integer.compare(this.index, other.index);
        }
    }
    @Override
    public String toString() {
        return "num: " + num + ", index: " + index;
    }
}
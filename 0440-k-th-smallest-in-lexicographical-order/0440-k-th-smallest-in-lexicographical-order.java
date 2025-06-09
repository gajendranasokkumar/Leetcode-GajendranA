class Solution 
{
    public int findKthNumber(int n, int k) 
    {
        // Step 1: Start from 1
        int curr = 1; 
        k -= 1;       // Because we already count 1 as the first number

        // Step 2: Loop until k becomes 0
        while (k > 0) 
        {
            // Step 3: Count nodes between curr and next prefix
            long steps = countSteps(n, curr, curr + 1); 

            if (steps <= k) 
            {
                // Step 4: Move to next sibling
                curr += 1;   
                k -= steps;
            } 
            else 
            {
                // Step 5: Move deeper into this prefix
                curr *= 10;  
                k -= 1;
            }
        }

        // Step 6: Return the k-th number
        return curr; 
    }

    // Helper function to count numbers between curr and next prefix
    private long countSteps(int n, long curr, long next) 
    {
        long steps = 0;
        while (curr <= n) 
        {
            steps += Math.min(n + 1L, next) - curr;
            curr *= 10;
            next *= 10;
        }
        
        return steps;
    }
}
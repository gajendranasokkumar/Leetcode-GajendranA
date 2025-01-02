class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        for(int i=1;i<=n;i++)
        {
            arr[i-1] = i;
        }
        // System.out.println(Arrays.toString(arr));

        int count = 0;
        int i = 0;
        int s = 1;
        
        for(i=0;i<n;i++)
        {
            if(count == n-1)
                break;
            if(s == k && arr[i] != 0)
            {
                // System.out.println(arr[i]);
                arr[i] = 0;
                count++;
                s = 1;
            }
            if(arr[i] != 0)
                s++;
            if(i == n-1)
                i = -1;
        }

        for(i=0;i<n;i++)
        {
            if(arr[i] != 0)
                return arr[i];
        }

        return 0;
    }
}
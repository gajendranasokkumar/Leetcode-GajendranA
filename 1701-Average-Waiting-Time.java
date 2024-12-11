class Solution {
    public double averageWaitingTime(int[][] customers) {
        long intial = 0;
        long total = 0;
        intial += customers[0][0] + customers[0][1]; 
        total += (intial - customers[0][0]);
        for(int i=1;i<customers.length;i++)
        {
            if(intial < customers[i][0])
            {
                intial = customers[i][0]+customers[i][1];
            }
            else
            {
                intial += customers[i][1];
            }

            total += (intial - customers[i][0]);

        }

        System.out.println(total);

        return (double)total/customers.length;
    }
}
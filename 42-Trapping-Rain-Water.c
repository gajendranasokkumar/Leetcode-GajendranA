int min(int a, int b)
{
    if((a==0 && b==0) || (a!=0 && b== 0) || (a==0 && b!= 0))    return 0;
    else if(a<b)    return a;
    else   return  b;
}



int trap(int* height, int heightSize) {
    int i,j;
    if(heightSize < 1)
    {
        return 0;
    }
    int firstHigh,secondHigh;
    int result[heightSize];
    firstHigh = secondHigh = 0;

    int var;

    for(i=0;i<heightSize;i++)
    {
        if(height[firstHigh] < height[i])
        {
            secondHigh = firstHigh;
            firstHigh = i;
            var = min(height[firstHigh]-height[i] , height[secondHigh]-height[i]);
            if(var<=0)
                result[i] = 0;
            else
                result[i] = var;
        }
        else
        {
            result[i] = height[firstHigh]-height[i];
        }
    }

    secondHigh = firstHigh;
    firstHigh = heightSize-1;

    for(i=firstHigh;i>secondHigh;i--)
    {
        if(height[firstHigh] < height[i])
        {
            firstHigh = i;
            var = min(height[secondHigh]-height[i], height[firstHigh]-height[i] );
            if(var<=0)
                result[i] = 0;
            else
                result[i] = var;
        }
        else
        {
            result[i] = height[firstHigh]-height[i];
        }

    }

    int sum = 0;
    for(i=0;i<heightSize;i++)
    {
        sum += result[i];
    }

    return sum;



}
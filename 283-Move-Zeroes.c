void moveZeroes(int* nums, int numsSize) {
    int i=0;
    int j=0;
    int index=0;
    for(int k=0;k<numsSize;k++)
    {
        if(nums[k]!=0)
        {
            nums[i++] = nums[k];
        }
    }
    while(i<numsSize)
    {
        nums[i] = 0;
        i++;
    }
}
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length,j=0;
        int[] arr=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(i+k-1<n) if(isValid(i,i+k-1,nums,k)) arr[j++]=nums[i+k-1]; else arr[j++]=-1;
            else break;
        }
        return arr;
    }
    public boolean isValid(int a,int b,int[] arr,int k){
        if(arr[a]>arr[b]) return false;
        int i=arr[a],j=arr[a]+k-1;
        while(a<=b){
            if(arr[a]!=i || arr[b]!=j) return false;
            a++;
            b--;
            i++;
            j--;
        }
        return true;
    }
}
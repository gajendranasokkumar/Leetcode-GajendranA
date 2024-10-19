class Solution {
    public char findKthBit(int n, int k) {
        
        String[] arr = new String[21];
        arr[1] = "0";
        for(int i=2;i<21;i++) {
            arr[i] = arr[i-1] + "1" + reverse(invert(arr[i-1]));
        }

        return arr[n].charAt(k-1);
    }

    public String invert(String original) {
        StringBuilder newstr = new StringBuilder();
        for(int i=0;i<original.length();i++)
            newstr.append((original.charAt(i) == '1') ? "0" : "1");
        return newstr.toString();
    }

    public String reverse(String original) {
        StringBuilder newstr = new StringBuilder(original);
        return newstr.reverse().toString();
    }
}
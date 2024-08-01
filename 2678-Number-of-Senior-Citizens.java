class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String i: details)
        {
            if(i.charAt(11) > '6' || (i.charAt(11) == '6' && i.charAt(12) > '0'))
                count++;
        }

        return count;
    }
}
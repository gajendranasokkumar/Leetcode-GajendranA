class Solution {
    public void fun(String s, int index, List<String> one, List<List<String>> result)
    {
        if(index == s.length())
        {
            result.add(new ArrayList<>(one));
            return;
        }

        for(int i=index; i<s.length(); i++)
        {
            if(isPalindrome(s, index, i))
            {
                one.add(s.substring(index, i+1));
                fun(s, i+1, one, result);
                one.remove(one.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right)
    {
        while(left <= right)
        {
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> one = new ArrayList<>();
        fun(s, 0, one, result);
        return result;
    }
}
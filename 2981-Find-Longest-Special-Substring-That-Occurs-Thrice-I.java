class Solution {
    int maxi = 0;
    public boolean checkWindow(StringBuilder sb, int w) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<=sb.length()-w;i++) {
            String temp = sb.substring(i, i+w);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        System.out.println(map);
        for(String one: map.keySet()) {
            if(map.get(one) >= 3 && isValid(one)) {
                maxi = Math.max(maxi, w);
                return true;
            }
        }
        return false;
    }
    public boolean isValid(String s) {
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i) != s.charAt(i+1))
                return false;
        }
        return true;
    }
    public int maximumLength(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        StringBuilder sb = new StringBuilder(s);
        while(left <= right) {
            int mid = (right + left) / 2;
            boolean flag = checkWindow(sb, mid);
            if(flag) 
                left = mid + 1;
            else
                right = mid - 1;
        }


        return maxi == 0 ? -1 : maxi;
    }
}
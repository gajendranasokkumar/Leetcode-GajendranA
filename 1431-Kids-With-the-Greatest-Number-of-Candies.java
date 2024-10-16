class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> l = new ArrayList<>();
        int max = candies[0], cal = 0;
        for(int i = 1; i < candies.length; i++){
            if( max < candies[i]){
                max = candies[i];
            }
        }
        
        for(int i = 0; i < candies.length; i++){
            cal = candies[i] + extraCandies;
            if( max <= cal){
                l.add(true);
            }else{
                l.add(false);
            }
        }
        return l;
    }
}
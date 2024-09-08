public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;  
        }

        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        for (int card : cardCount.keySet()) {
            int freq = cardCount.get(card);
            if (freq > 0) { 
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i; 
                    int currentCount = cardCount.getOrDefault(currentCard, 0);

                    if (currentCount < freq) {
                        return false; 
                    }
                    cardCount.put(currentCard, currentCount - freq);  
                }
            }
        }

        return true;  
    }

}

class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        
        int length = (1 << n) - 1;  // 2^n - 1
        
        // The middle bit in S_n is at position (length / 2) + 1
        int mid = length / 2 + 1;
        
        if (k == mid) {
            // If k is the middle bit, it is always '1'
            return '1';
        } else if (k < mid) {
            // If k is in the first half, it is the same as in S_{n-1}
            return findKthBit(n - 1, k);
        } else {
            // If k is in the second half, find the corresponding bit in the reverse-inverted S_{n-1}
            // The corresponding bit in the first half of S_{n-1} is at position (length - k + 1)
            char invertedBit = findKthBit(n - 1, length - k + 1);
            return (invertedBit == '0') ? '1' : '0';
        }
    }
}

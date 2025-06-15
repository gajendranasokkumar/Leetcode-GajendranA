class Solution {
    public int smallestDivisor(int[] arr, int k) {
        int low = 1;
        int high = getMax(arr);
        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                answer = mid; // possible answer, try smaller
                high = mid - 1;
            } else {
                low = mid + 1; // try bigger divisor
            }
        }
        return answer;
    }

    private boolean isValid(int[] arr, int k, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor; // this is equivalent to ceil(num/divisor)
            if (sum > k) return false; // early exit
        }
        return true;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
        
        // ds.add(arr[ind]);
        // findCombinations(ind + 1, arr, target - arr[ind], ans, ds);
        // ds.remove(ds.size() - 1);
        // findCombinations(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
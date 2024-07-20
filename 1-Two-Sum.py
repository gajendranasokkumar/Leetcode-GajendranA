class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i in range(len(nums)):
            rem = target - nums[i]
            if rem in hashmap:
                return [i, hashmap[rem]]
            hashmap[nums[i]] = i
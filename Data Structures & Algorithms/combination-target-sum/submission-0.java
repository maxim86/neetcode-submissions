class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        
        build(nums, 0, target, result, new ArrayList<Integer>());

        return result;
    }

    void build(int[] nums, int numsIdx, int target, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }

        if (target <= 0) return;
        if (numsIdx > nums.length - 1) return;

        //including 
        current.add(nums[numsIdx]);
        build(nums, numsIdx, target - nums[numsIdx], result, current);
        current.removeLast();

        //excluding
        build(nums, numsIdx + 1, target, result, current);
    }
}

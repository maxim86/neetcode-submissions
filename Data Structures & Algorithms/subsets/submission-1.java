class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();

        build(result, nums, 0, new ArrayList<Integer>());

        return result;
    }

    void build(List<List<Integer>> result, int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        //buld without current
        build(result, nums, index + 1, current);

        //build with current + backtrack
        current.add(nums[index]);
        build(result, nums, index + 1, current);
        current.remove(current.size() - 1);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>(); //value, idx seen

        for (int i=0; i<nums.length; i++) {
            Integer idx = visited.get(target - nums[i]);
            visited.put(nums[i], i);
            if(idx != null)
                return new int[]{idx, i};
        }

        return new int[]{};
    }
}

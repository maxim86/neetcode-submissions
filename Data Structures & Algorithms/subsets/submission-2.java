class Solution {
    int currIdx = 0;
    public List<List<Integer>> subsets(int[] nums) {
        var current = new LinkedList<Integer>();
        var result = new ArrayList<List<Integer>>();
        var currIdx = 0;

        backtrack(current, result, currIdx, nums);

        return result;
    }

    public void backtrack(List<Integer> current, List<List<Integer>> result, int currIdx, int[] nums) {
        if (currIdx == nums.length) {
            result.add(new ArrayList(current));
            return;
        }
           
        var currVal = nums[currIdx];
        currIdx++;
        
        //don't add current nums[idx]
        backtrack(current, result, currIdx, nums);

        //add current nums[idx]
        current.addLast(currVal);
        backtrack(current, result, currIdx, nums);
        current.removeLast();

    }
}

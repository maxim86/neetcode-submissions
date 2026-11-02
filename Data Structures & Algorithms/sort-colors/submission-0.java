class Solution {
    public void sortColors(int[] nums) {
        int[] counters = new int[3];

        for (int i = 0; i < nums.length; i++) {
            counters[nums[i]] = counters[nums[i]] + 1;
        }

        int j = 0;
        for (int c = 0; c < 3; c++) {
            while(counters[c] > 0) {
                nums[j] = c;
                counters[c] = counters[c] - 1;
                j++;
            }
        }
    }
}
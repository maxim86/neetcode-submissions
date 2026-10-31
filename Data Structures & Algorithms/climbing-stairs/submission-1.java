class Solution {
    int[] saved = new int[45];
    
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (saved[n - 1] != 0) return saved[n - 1]; 

        int sum = 0;
        if (n >= 2)
            sum += climbStairs(n - 1);
        if (n >= 3)
            sum += climbStairs(n - 2);

        saved[n - 1] = sum;
        return sum;
    }
}

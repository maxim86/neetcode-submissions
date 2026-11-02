class Solution {
    // m - num rows 
    // n - num cols
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0; 
        int r = m * n - 1;  

        while (l <= r) {
            int mid = (l + r) / 2;
            int[] coords = coordinatesFromIdx(mid, m, n);

            var currVal = matrix[coords[0]][coords[1]];
            if (currVal == target) return true;
            if (currVal < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }

        return false;
    }

    int[] coordinatesFromIdx(int i, int m, int n) {
        return new int[]{i / n, i % n};
    } 
}

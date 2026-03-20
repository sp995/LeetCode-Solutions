import java.util.Arrays;

public class MinimumAbsoluteDifferenceSlidingSubmatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int[] nums = new int[k * k];
                int idx = 0;
                for (int x = i; x < i + k; x++)
                    for (int y = j; y < j + k; y++)
                        nums[idx++] = grid[x][y];

                Arrays.sort(nums);
                int minDiff = Integer.MAX_VALUE;
                for (int p = 1; p < nums.length; p++)
                    if (nums[p] != nums[p - 1])
                        minDiff = Math.min(minDiff, nums[p] - nums[p - 1]);

                ans[i][j] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
            }
        }
        return ans;
    }
}

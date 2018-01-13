/**
 * Created by think on 2018/1/12.
 */
public class main {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }

    //    Status: Time Limit Exceeded
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
        return max;
    }

    //一维动态规划( 动态规划动态转移方程 )
    //time: o(n) space:o(n)
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    //一维动态规划:简化
    //time: o(n) space:o(1)
    public static int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}

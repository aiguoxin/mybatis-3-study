package leetcode.editor.cn.dp;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-l-ncf8/
 *
 * 开始没思路，主要是建立动态转移方程。优化：可以使用滚动数组方式。
 */
public class MinCostClimb {

    public static int minCostClimbingStairs(int[] cost) {
        //楼顶
        int n = cost.length+1;
        int[] dp = new int[n];
        //可以从第一和第二阶开始，所以都是0
        dp[0]=dp[1]=0;
        for(int i=2;i<n;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}

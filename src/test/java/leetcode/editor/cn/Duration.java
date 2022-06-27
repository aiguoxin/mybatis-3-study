package leetcode.editor.cn;

/**
 * 6/27/22 07:52
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/teemo-attacking/
 */
public class Duration {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
//        int result = 0;
//        int end = 0;
//        for (int i = 0; i < timeSeries.length; i++) {
//            int start = timeSeries[i];
//            if (end > start) {
//                start = end;
//            }
//            if (end == start && duration > 1) {
//                result--;
//            }
//
//            end = timeSeries[i] + duration - 1;
//            result += end - start + 1;
//        }
//
//        return result;
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        System.out.println(findPoisonedDuration(timeSeries, 1));
    }
}

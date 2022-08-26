/**
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package leetcode.editor.cn;

/**
 * 7/31/22 16:18
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/maximum-average-subarray-i/
 */
public class MaxAvg {

    public static double findMaxAverage(int[] nums, int k) {
        /**时间复杂度太高，通不过**/
//        long sum = Long.MIN_VALUE;
//        for (int i = 0; i <= nums.length - k; i++) {
//            long val = 0;
//            for (int j = i; j < i + k; j++) {
//                val += nums[j];
//            }
//            if (val > sum) {
//                sum = val;
//            }
//        }
//        return (double) sum / k;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            //当前和，等于减掉第一个元素，加上后面一个元素
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(findMaxAverage(nums, 1));
    }
}

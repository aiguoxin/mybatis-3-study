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
package leetcode.editor.cn.greedy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 */
public class LargeSum {

    public static void main(String[] args) {
        int[] nums = {2,-3,-1,5,-4};
        System.out.println(largestSumAfterKNegations(nums,2));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum =0;
        int count =0;
        for(int i = 0; i< nums.length;i++){
            if(count < k) {
                if(nums[i] < 0 && count<k){
                    nums[i] = Math.abs(nums[i]);
                    count ++;
                }
            }
        }

        Arrays.sort(nums);
        if(k == count){
            sum = nums[0];
        }else{
            if(((k-count) & 1) == 0){
                sum = nums[0];
            }else{
                sum = -nums[0];
            }
        }

        if(nums.length >1) {
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
            }
        }

        return sum;
    }
}

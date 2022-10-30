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
package leetcode.editor.cn.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/get-maximum-in-generated-array/
 *
 */
public class MaxNum {
    public static int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;

        for(int i=2;i<n+1;i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
        }

        /***最后按照奇偶返回，不行！！***/
//        Arrays.stream(nums).max().getAsInt();
        Arrays.sort(nums);
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(15));
    }
}

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

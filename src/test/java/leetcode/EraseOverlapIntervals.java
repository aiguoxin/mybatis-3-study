/**
 *    Copyright 2009-2021 the original author or authors.
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
package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/** 2021/6/8 下午4:21 aiguoxin 说明: https://leetcode-cn.com/problems/non-overlapping-intervals/ */
public class EraseOverlapIntervals {

    private static Solution s = new Solution();

    public static void main(String args[]) {
        final Scanner reader = new Scanner(System.in);
        int[][] intervals;
        while (reader.hasNextLine()) {
            final String next = reader.nextLine();
            intervals = transfer2Array(next);
            final int removeNum = s.eraseOverlapIntervals(intervals);
            System.out.println(removeNum);
        }
        reader.close();
    }

    private static int[][] transfer2Array(String next) {
        if (next != null && next != "") {
            String[] arrayStr = next.split("],");
            int[][] intervals = new int[arrayStr.length][2];
            for (int i = 0; i < arrayStr.length; i++) {
                String[] val =
                        arrayStr[i].replace("[", "").replace("]", "").replace(" ", "").split(",");
                intervals[i][0] = Integer.valueOf(val[0]);
                intervals[i][1] = Integer.valueOf(val[1]);
                //                System.out.println(intervals[i][0] + "," + intervals[i][1]);
            }
            return intervals;
        }
        return new int[0][];
    }
}

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
        if (n == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 0; // 用来记录重叠区间的个数
        int rightEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {

            if (intervals[i][0] >= rightEnd) {

                rightEnd = intervals[i][1];

            } else {

                count++;
            }
        }
        return count;
    }
}

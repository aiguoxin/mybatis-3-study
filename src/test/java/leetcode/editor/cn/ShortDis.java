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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 7/31/22 16:49
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/shortest-distance-to-a-character/
 */
public class ShortDis {
    public static int[] shortestToChar(String s, char c) {
        char[] sCh = s.toCharArray();
        int[] res = new int[sCh.length];
        List<Integer> idxSet = new ArrayList<>();

        for (int i = 0; i < sCh.length; i++) {
            if (Objects.equals(c, sCh[i])) {
                idxSet.add(i);
            }
        }

        for (int i = 0; i < sCh.length; i++) {
            if (idxSet.contains(i)) {
                res[i] = 0;
                continue;
            } else {
                int dis = Integer.MAX_VALUE;
                for (int j = 0; j < idxSet.size(); j++) {
                    int val = Math.abs(i - idxSet.get(j));
                    if (val < dis) {
                        dis = val;
                    }
                }
                res[i] = dis;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(Arrays.toString(shortestToChar(s, 'e')));
    }
}

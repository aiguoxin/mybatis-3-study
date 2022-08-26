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

import java.util.Set;
import java.util.TreeSet;
import leetcode.bfs.TreeNode;

/**
 * 8/13/22 14:26
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondNode {
    static Set<Integer> tSet = new TreeSet<>();

    public static int findSecondMinimumValue(TreeNode root) {
        if (root != null) {
            tSet.add(root.val);
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }

        if (tSet.size() > 1) {
            int count = 0;
            for (Integer t : tSet) {
                count++;
                if (count == 2) {
                    return t;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

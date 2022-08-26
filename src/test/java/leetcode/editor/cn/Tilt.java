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

import leetcode.bfs.TreeNode;

/**
 * 7/10/22 16:05
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/binary-tree-tilt/
 */
public class Tilt {
    int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = dfs(root.left);
        int sumRight = dfs(root.right);
        /***
         * 递归过程需要用，全局sum
         */
        sum += Math.abs(sumLeft - sumRight);
        /**一定需要加上root.val**/
        return sumLeft + sumRight + root.val;
    }

    public static void main(String[] args) {

    }
}

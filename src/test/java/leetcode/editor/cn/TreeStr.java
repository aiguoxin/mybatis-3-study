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
 * 7/27/22 22:20
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/construct-string-from-binary-tree/submissions/
 */
public class TreeStr {

    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        if (root.left == null) {
            return new StringBuilder().append(root.val).append("()").append("(").append(tree2str(root.right)).append(
                    ")").toString();
        }

        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(")
                .append(tree2str(root.right)).append(")").toString();
    }

    public static void main(String[] args) {

    }
}

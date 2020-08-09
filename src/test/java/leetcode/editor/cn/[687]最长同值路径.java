/**
 *    Copyright 2009-2020 the original author or authors.
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
//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归


//leetcode submit region begin(Prohibit modification and deletion)


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

class Solution {
    int result;

    public int longestUnivaluePath(TreeNode root) {
        result=0;
        computeLength(root);
        return result;
    }

    private int computeLength(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = computeLength(root.left);
        int right = computeLength(root.right);
        int arrowLeft = 0, arrowRight =0 ;
        if(root.left != null && root.left.val == root.val){
            arrowLeft += left + 1;
        }

        if(root.right != null && root.right.val == root.val){
            arrowRight += right + 1;
        }
        result = Math.max(result, arrowLeft+ arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

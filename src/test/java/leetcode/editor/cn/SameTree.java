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
package leetcode.editor.cn;//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 777 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.bfs.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution032211{
    /***用的深度搜索，递归方式。如果使用广度搜索，则需要借助队列！！！***/
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if(p == null && q== null){
            return true;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
//        n1.right = n3;

        TreeNode n11 = new TreeNode(1);
        TreeNode n21 = new TreeNode(2);
//        TreeNode n31 = new TreeNode(4);
        n11.right = n21;
//        n11.right = n31;
        System.out.println(isSameTree(n1, n11));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

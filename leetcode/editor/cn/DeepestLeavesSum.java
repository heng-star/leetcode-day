//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 104] 之间。 
// 1 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 134 👎 0


package leetcode.editor.cn;

import javax.swing.text.TabExpander;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author [你的昵称或名字]
 * 2022-08-17 23:09:13  // 生成当前你做题的时间
 */
public class DeepestLeavesSum{
  public static void main(String[] args) {
       Solution solution = new DeepestLeavesSum().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int res=0;
        LinkedList<TreeNode> l=new LinkedList<>();
        l.addLast(root);
        int num=0;
        List<TreeNode> list=new ArrayList<>();
        while (!l.isEmpty()){
            num=l.size();
            list.clear();
            for(int i=0;i<num;i++){
                TreeNode p=l.pollFirst();
                list.add(p);

                if(p.left!=null){
                    l.addLast(p.left);
                }
                if(p.right!=null){
                    l.addLast(p.right);
                }
            }
        }
        for(TreeNode e:list){
            res=res+e.val;
        }
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。 
//
// 返回移除了所有不包含 1 的子树的原二叉树。 
//
// 节点 node 的子树为 node 本身加上所有 node 的后代。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,0,0,1]
//输出：[1,null,0,null,1]
//解释：
//只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,1,0,0,0,1]
//输出：[1,null,1,null,1]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,1,0,1,1,0,1,0]
//输出：[1,1,0,1,1,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 200] 内 
// Node.val 为 0 或 1 
// 
// Related Topics 树 深度优先搜索 二叉树

package leetcode.editor.cn;


/**
 * @author [你的昵称或名字]
 *   // 生成当前你做题的时间
 */
public class BinaryTreePruning{
  public static void main(String[] args) {
       Solution solution = new BinaryTreePruning().new Solution();
       //[1,null,0,0,1]



      TreeNode t31=new TreeNode(0);
      TreeNode t32=new TreeNode(0);
      TreeNode t22=new TreeNode(0,t31,t32);
      TreeNode t21=new TreeNode();
      TreeNode root=new TreeNode(0,null,t22);

      solution.pruneTree(root);
      System.out.println(root);



  }
  

//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
     */
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            while(f(root,null,0));
            return root;
        }

        public boolean f(TreeNode root,TreeNode pre,int k){
            boolean t=false;
            if(root==null){return true;}
            else{
                if(root.left!=null){
                    t=t||f(root.left,root,-1);
                }
                if(root.right!=null){
                    t=t||f(root.right,root,1);
                }
                if(root.val==0){
                    if(root.left ==null && root.right==null){
                        if(k==-1){
                            pre.left=null;
                            return true;
                        }
                        if(k==1){
                            pre.right=null;
                            return true;
                        }
                        if(k==0){
                            root=null;
                            return false;
                        }
                    }
                }
            }
            return t;

        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}

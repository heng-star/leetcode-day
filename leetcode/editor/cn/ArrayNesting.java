//索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。 
//
// 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。 
//
// 
//
// 示例 1: 
//
// 输入: A = [5,4,0,3,1,6,2]
//输出: 4
//解释: 
//A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
//
//其中一种最长的 S[K]:
//S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
// 
//
// 
//
// 提示： 
//
// 
// N是[1, 20,000]之间的整数。 
// A中不含有重复的元素。 
// A中的元素大小在[0, N-1]之间。 
// 
// Related Topics 深度优先搜索 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

/**
 * @author [你的昵称或名字]
 *   // 生成当前你做题的时间
 */
public class ArrayNesting{
  public static void main(String[] args) {
       Solution solution = new ArrayNesting().new Solution();
       int[] a={1,2,3,4,5,6,0};
      int i = solution.arrayNesting(a);
      System.out.println(i);
  }
  

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      int n;
      ArrayList<Integer>[] l;

      HashMap<Integer,node> map=new HashMap<>();

    public int arrayNesting(int[] nums) {

        int ans = 0, n = nums.length;


        byte b=0;

        int a=127;

        int c=128;

        Integer d=128;

        int f=new Integer("10");


        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class node{
      int v;
      ArrayList<node> next;
      public node(int val){
          v=val;
      }
      public void add(node n){
          next.add(n);
      }
    }
}

//给定一个整数数组 asteroids，表示在同一行的行星。 
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 104 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics 栈 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author [你的昵称或名字]
 *   // 生成当前你做题的时间
 */
public class AsteroidCollision{
  public static void main(String[] args) {
       Solution solution = new AsteroidCollision().new Solution();
       int[] a=solution.asteroidCollision(new int[]{-2,-1,1,2});
      for (int i : a) {
          System.out.println(i);
      }
//       a.forEach(System.out::print);
  }
  

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list=new ArrayList<>();

        List<Integer> list1=new ArrayList<>();//
        List<Integer> list2=new ArrayList<>();//
        int[] res=null;

        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                list1.add(asteroids[i]);
            }else {
                list2.add(asteroids[i]);
            }
            if(!list1.isEmpty() && !list2.isEmpty()){
                while (list1.size()==1){
                    if(-1*list2.get(list2.size()-1)<list1.get(0)){
                        list2.remove(0);
                    }else if(-1*list2.get(list2.size()-1)==list1.get(0)){
                        list1.remove(0);
                        list2.remove(list2.size()-1);
                    }
                    else{
                        list1.remove(0);
                    }
                    if (list2.isEmpty() || list1.isEmpty()){
                        break;
                    }
                }
                if (list2.isEmpty() || list1.isEmpty()){
                    continue;
                }
                while (list2.size()==1){
                    if(-1*list2.get(0)>list1.get(list1.size()-1)){
                        list1.remove(list1.size()-1);
                    }else if(-1*list2.get(0)==list1.get(list1.size()-1)){
                        list2.remove(0);
                        list1.remove(list1.size()-1);
                    }
                    else {
                        list2.remove(0);
                    }
                    if(list1.isEmpty()||list2.isEmpty()){
                        break;
                    }
                }
            }

        }
        int k=0;
        if(!list1.isEmpty()){
            res=new int[list1.size()];
            while (k<list1.size()){
                res[k]=list1.get(k++);
            }
        }
        if(!list2.isEmpty()){
            res=new int[list2.size()];
            while (k<list2.size()){
                res[k]=list2.get(k++);
            }
        }
        if(res==null){
            res=new int[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

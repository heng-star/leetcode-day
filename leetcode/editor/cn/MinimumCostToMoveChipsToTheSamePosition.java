//有 n 个筹码。第 i 个筹码的位置是 position[i] 。 
//
// 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为: 
//
// 
//
// 
// position[i] + 2 或 position[i] - 2 ，此时 cost = 0 
// position[i] + 1 或 position[i] - 1 ，此时 cost = 1 
// 
//
// 返回将所有筹码移动到同一位置上所需要的 最小代价 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：position = [1,2,3]
//输出：1
//解释：第一步:将位置3的筹码移动到位置1，成本为0。
//第二步:将位置2的筹码移动到位置1，成本= 1。
//总成本是1。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：position = [2,2,2,3,3]
//输出：2
//解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
// 
//
// 示例 3: 
//
// 
//输入：position = [1,1000000000]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= chips.length <= 100 
// 1 <= chips[i] <= 10^9 
// 
// Related Topics 贪心 数组 数学

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author [你的昵称或名字]
 *   // 生成当前你做题的时间
 */
public class MinimumCostToMoveChipsToTheSamePosition{
  public static void main(String[] args) {
       Solution solution = new MinimumCostToMoveChipsToTheSamePosition().new Solution();
       int [] s={1,1000000000};
       int t=solution.minCostToMoveChips(s);
       System.out.println(t);
  }
  

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostToMoveChips(int[] position) {

        Map<Integer,Integer> map=new HashMap<>();
        TreeMap<Integer,Integer> tmap=new TreeMap<>();

        int max1=0;
        int i1=0;
        int max2=0;
        int i2=0;

        int cost1=0;
        int cost2=0;

        for(int i=0;i<position.length;i++){
            map.put(position[i],map.getOrDefault(position[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getKey()%2==0){
                if(max1<e.getValue()){
                    max1=e.getValue();
                    i1=e.getKey();
                }
            }
            if(e.getKey()%2==1){
                if(max2<e.getValue()){
                    max2=e.getValue();
                    i2=e.getKey();
                }
            }
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if((e.getKey()-i1)%2==0){
                cost1=cost1+e.getValue();
            }
            if((e.getKey()-i2)%2==0){
                cost2=cost2+e.getValue();
            }
        }
        System.out.println(cost1);
        System.out.println(cost2);
        return cost1>cost2 ? cost2:cost1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

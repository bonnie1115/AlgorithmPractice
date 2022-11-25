package cn.algorithmpractice.ld;

import java.util.ArrayList;
import java.util.List;

/*给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

示例 1：
输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]
示例 2：
输入：nums = [1,1]
输出：[2]
 提示：
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。*/
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      //第一遍只能照抄了= =
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1; //防止数组越界

            if(nums[index]>0){
                nums[index]*=-1;//把出现过得数作为索引,并把对应得值改为负数
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){   //如果谁是正数,这个数没有作为索引出现过
                list.add(i+1);//加一是因为从1开始

            }
        }
        return list;


    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
       //原地哈希解法,只适合与数组的值的大小限定在1到n中间
        //https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/solution/java-yuan-di-ha-xi-si-lu-qing-xi-dai-ma-a12yd/
        int len = nums.length;
        int index = 0;
        while(index<len){
            if( nums[index]==index+1){  //如果下标+1和值相等,那就不用特殊处理
                index ++;

            }else{
                int targetIndex = nums[index] -1;
                if(nums[targetIndex]==nums[index]){
                    index++;
                    continue;
                }else{
                    //交换位置
                    int temp = nums[targetIndex];
                    nums[targetIndex]=nums[index];
                    nums[index] = temp;


                }

            }

        }

        List<Integer> res = new ArrayList<Integer>();
        for (int i=0;i<len;index++){
            if(nums[i]!=i+1){
                res.add(i+1);
            }
        }
        return res;
    }

}

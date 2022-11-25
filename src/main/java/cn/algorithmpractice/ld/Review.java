package cn.algorithmpractice.ld;

import java.util.HashMap;

//20220316 回顾第3遍? for 循环里面的内容没想出来
public class Review {

    //爬楼梯
    public int ClimbStairs(int n){

        int pre = 2;
        int prePre = 1;
        int sum = 0;
        if (n==1){
            return sum=1;
        }
        if(n==2){
            return sum = 2;
        }
        for(int i=3;i<=n;i++){
            sum = pre+prePre;
            prePre =pre;
            pre = sum;

        }
        return  sum;

    }


    //两数之和  20220316三刷??还是无法一次性写出来,知道要用hashmap解决
/*题目:  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。
例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]*/


  //  public int[] twoSum(int[] nums,int target){
//        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        //疑问,这个map存数值的结构?

//       /**/ for(int i=0;i<nums.length;i++){
//                    }

  //  }

    public static void main(String[] args) {

    }
}

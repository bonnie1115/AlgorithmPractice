/*
package cn.algorithmpractice.ld;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum2(int[] nums, int target) {
        int[] result;
        for(int i=0;i<=nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return  result[i,j];
                }
            }
        }


    }


    //解法二:更优解决
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> storeNums = new HashMap<Integer, Integer>(nums.length,1);
        int[] result= new int[2];

        for(int i=0;i<=nums.length;i++){
            int another = target - nums[i];
            Integer anotherIndex = storeNums.get(another);
            if(null != anotherIndex){
                result[0]=anotherIndex;
                result[1]=i;
                break;
            }else{
                storeNums.put(nums[i],i);
            }
        }
        return result;
    }

}
*/

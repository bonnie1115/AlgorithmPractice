package cn.algorithmpractice.ld;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

       int k =m+n;
       int[] temp = new int[k];
       for (int index =0,nums1Index=0,nums2Index=0;index < k;index++ ){
           if(nums1Index >=m) {/*nums1数组已经取完,完全取nums2数组的值即可*/
               temp[index]=nums2[nums2Index++];
           }else if(nums2Index>=n){/*nums2数组已经取完,完全取nums1数组的值即可*/
               temp[index]=nums1[nums1Index++];
           }else if (nums1[nums1Index]<nums2[nums2Index]){
               /*nums1数组的元素值小于nums2数组,取nums1数组的值*/
               temp[index] = nums1[nums1Index++];
           }else {
               /*nums2数组的元素值小于等于nums1左边数组,取nums2数组的值*/
               temp[index] = nums2[nums2Index++];
           }

       }

       for(int i=0;i<k;i++){
           nums1[i]=temp[i];
       }


    }

    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int k=m+n;
        for(int index = k-1,nums1Index=m-1,nums2Index=n-1;index>=0;index--){
            if(nums1Index<0){/*nums1的值已经取完,完全取nums2的值*/
                nums1[index]=nums2[nums2Index--];
            }else if(nums2Index<0){
                break;
            }else if(nums1[nums1Index]>nums2[nums2Index]){/*nums1元素的值大于nums2,取nums1的值*/
                nums1[index]=nums1[nums1Index--];
            }else{/*nums2元素的值大于nums1,取nums2的值*/
                nums1[index]=nums2[nums2Index--];
            }
        }
    }

    //20220628再次尝试
    public void merge3(int[] nums1, int m, int[] nums2, int n){
        int keySum = m +n;
        for(int len =keySum-1,len1 = m-1,len2 = n-1;len>=0;len--){
            if(len1<0){
                nums1[len]=nums2[len2--];//???可以指针设置为从后向前遍历，每次取两者之中的较大者放进nums1的最后面
            }else if(len2<0){
                break;
            }else if(nums1[len1]<nums2[len2]){
                nums1[len]=nums2[len2--];
            }else{
                nums1[len]=nums1[len1--];
            }
        }

        /*解题思路:
        * 1.关键点,定义变量key =m+n  是nums1的实际总数组长度
        * 2.从后往前遍历,数大的放至nums1最末尾 ,key也要递减,数字比较大的指针也要递减
        * 3.边界值 当nums1的长度为0之后,直接将nums2的数全部复制给nums[key]*/



    }

}

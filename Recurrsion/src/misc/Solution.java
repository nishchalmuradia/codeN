package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i< nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;

            while(k>j){
                if(nums[i]+nums[j]+nums[k]==0){

                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                if(nums[i]+nums[j]+nums[k]<0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}
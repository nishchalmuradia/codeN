/*
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testt {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList();

        if (nums.length < 3) {
            return result;
        }
        //sorting
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int lo = i;
                int hi = nums.length - 1;

                while (lo < hi) {
                    if (nums[lo] + nums[hi] == target) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        //remobve duplicates
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi++;

                        lo++;
                        hi++;
                    } else if (nums[lo] + nums[hi] < target) {
                        lo++;
                    } else {
                        hi++;
                    }

                }
            }
        }
        return result;

    }
    public static void main(String[] args) {

        int[] nums1 = new int[0];int[] nums2 = new int[0];

            int result[] = new int[nums1.length + nums2.length];
        for(int i=0; i<nums1.length;i++){
            result[i] = nums1[i];
        }
        int p=nums1.length;
        for(int i= 0; i<nums2.length;i++, p++){
            result[p] = nums2[i];
        }
        int sum=0;
        for(int i: result){
            sum+= i;
        }
    Double s = Double.valueOf(sum/result.length);
        }
    }
}
*/

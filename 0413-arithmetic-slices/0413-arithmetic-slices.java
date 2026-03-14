class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

         int windowSize = 3;
        if(nums.length < 3) 
            return 0;
        int diff = nums[1] - nums[0];
        int start = 0;
        int end = 2;
        int ans =0;

        while (end < nums.length) {
            if(nums[end] - nums[end-1] ==  diff) {
                if (end - start +1 >= windowSize)
                    ans =( end - start -1) +ans;
            }else {
                start = end-1;
                diff = nums[end] - nums[start];
            }
            end++;
        }
        return ans;
        
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
         int MinSize = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < nums.length){
            sum += nums[end];
            while (sum >= target) {
                    MinSize = Math.min(MinSize, end - start +1);
                    sum -= nums[start];
                    start++;
            }

            end++;



        }
        return MinSize == Integer.MAX_VALUE ? 0 : MinSize;
        
    }
}
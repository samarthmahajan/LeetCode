class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long ans = 0L;
        long curr = 0L;
        for (int x : nums) {
            if (x == 0) {
                curr++; // extend zero-run
                ans += curr; // add all subarrays ending here
            } else {
                curr = 0L; // break the run
            }
        }
        return ans;
    }

}
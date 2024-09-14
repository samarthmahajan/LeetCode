class Solution {
    public int longestSubarray(int[] nums) {
        // Step 1: Find the maximum value in the array
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Find the longest subarray where every element is equal to maxVal
        int maxLength = 0;
        int currentLength = 0;

        for (int num : nums) {
            if (num == maxVal) {
                // If the current element is equal to the maxVal, increment the length
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Reset the current length when the streak of maxVal is broken
                currentLength = 0;
            }
        }

        return maxLength;
    }
}
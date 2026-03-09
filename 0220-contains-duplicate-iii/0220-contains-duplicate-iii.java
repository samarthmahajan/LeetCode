class Solution {
   public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    // We use a TreeSet to keep the numbers in the window sorted
    // Long is used to prevent integer overflow during subtractions
    TreeSet<Long> window = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {
        long current = (long) nums[i];

        // 1. Find the smallest number in the set that is >= (current - valueDiff)
        Long successor = window.ceiling(current - valueDiff);

        // 2. Check if that number is also <= (current + valueDiff)
        if (successor != null && successor <= current + valueDiff) {
            return true;
        }

        // 3. Add current number to the window
        window.add(current);

        // 4. Keep the window size within indexDiff
        if (i >= indexDiff) {
            window.remove((long) nums[i - indexDiff]);
        }
    }

    return false;
}
}
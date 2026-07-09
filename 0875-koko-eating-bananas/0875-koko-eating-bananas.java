class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int left = 1;
        int right = maxPile;
        int minSpeed = right;
        while (left<= right){
            int mid = left + (right - left) / 2;
            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }
            if (totalHours <= h) {
                minSpeed = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  minSpeed;
    }
}
class Solution {
    public double new21Game(int n, int k, int maxPts) {
           if (k == 0) return 1.0;
        if (n >= k - 1 + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0; // sum of dp[j] for j in the valid window
        double ans = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                // Still allowed to draw from i, so it contributes to future states' window
                windowSum += dp[i];

            } else {
                // i >= k means the game stops here
                ans += dp[i];
            }

            // Slide the window left: remove dp[i - maxPts] if it was part of the window (i - maxPts < k)
            int out = i - maxPts;
            if (out >= 0 && out < k) {
                windowSum -= dp[out];
            }
        }
        return ans;
        
    }
}
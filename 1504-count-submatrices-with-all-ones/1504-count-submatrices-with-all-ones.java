class Solution {
    public int numSubmat(int[][] mat) {


        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        long ans = 0;

        for (int r = 0; r < m; r++) {
            // 1) Build histogram for this row
            for (int c = 0; c < n; c++) {
                heights[c] = (mat[r][c] == 1) ? heights[c] + 1 : 0;
            }

            // 2) Monotonic increasing stack of (height, count)
            Deque<int[]> st = new ArrayDeque<>();
            long sum = 0;

            for (int c = 0; c < n; c++) {
                int h = heights[c];
                int cnt = 1;

                while (!st.isEmpty() && st.peek()[0] >= h) {
                    int[] top = st.pop();
                    sum -= (long) top[0] * top[1]; // remove prior contribution
                    cnt += top[1];                 // merge segments
                }

                if (h > 0) {
                    sum += (long) h * cnt;
                    st.push(new int[]{h, cnt});
                } else {
                    // h == 0 breaks all rectangles ending here
                    sum = 0;
                    st.clear();
                }

                ans += sum;
            }
        }
        return (int)ans;
        
    }
}
class Solution {
    public int numSubmat(int[][] mat) {


        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int ans = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                heights[c] = (mat[r][c] == 1) ? heights[c] + 1 : 0;
            }

            Deque<int[]> st = new ArrayDeque<>();
            long sum = 0;

            for (int c = 0; c < n; c++) {
                int h = heights[c];
                int cnt = 1;

                while (!st.isEmpty() && st.peek()[0] >= h) {
                    int[] top = st.pop();
                    sum -= (long) top[0] * top[1]; 
                    cnt += top[1];               
                }

                if (h > 0) {
                    sum += (long) h * cnt;
                    st.push(new int[]{h, cnt});
                } else {
                    sum = 0;
                    st.clear();
                }

                ans += sum;
            }
        }
        return ans;
        
    }
}
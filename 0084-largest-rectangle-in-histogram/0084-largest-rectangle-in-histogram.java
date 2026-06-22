class Solution {
    public int largestRectangleArea(int[] heights) {
          int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Nearest Smaller to Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) 
                stack.pop();
            
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(i);
        }

        stack.clear(); // Reuse stack

        // Nearest Smaller to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) 
                stack.pop();
            System.out.println(n);
            right[i] = stack.isEmpty() ? n : stack.peek();
            System.out.println(right[i]);
            stack.push(i);
        }
       System.out.println(Arrays.toString(left));
       System.out.println(Arrays.toString(right));

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
        
    
}
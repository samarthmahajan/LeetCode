class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         var res = new int[nums.length-k+1] ;
        if (k == 0 || k > nums.length) {
            return res;
        }
        int left =0 , right = 0;
        
        Deque<Integer> queue = new ArrayDeque<>();
        while (right < nums.length) {
           while (!queue.isEmpty() && nums[right] > queue.peekLast()) {
                queue.pollLast();
            }


            queue.offerLast(nums[right]);
            if (right - left + 1 == k ) {


                res[left] = queue.peek();
                if ( !queue.isEmpty() &&  queue.peek()== nums[left]) {

                    queue.pop();
                }
                left++;


            }

            right++;
        }
        return res;

        
    }
}

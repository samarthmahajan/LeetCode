class Solution {
    public int[] nextGreaterElements(int[] nums) {

        ArrayDeque<Integer>  stack = new ArrayDeque<>();
        int length = nums.length;
        int[] res = new int[length];
        for(int i = 2*length-1; i>=0 ; i--){
            int currentIndex  = i%length;
            while (!stack.isEmpty() && nums[currentIndex]>=stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[currentIndex]= -1;
            }else {
                res[currentIndex]= stack.peek();
            }
            stack.push(nums[currentIndex]);
        }
        return res;
    
        
    }
}
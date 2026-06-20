class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreatest = new HashMap<>();
        converToNextgreatest(nums2, nextGreatest);
        for (int i=0; i<=nums1.length-1; i++){
            nums1[i] = nextGreatest.get(nums1[i]);
        }
        return nums1;
        
    }
      private void converToNextgreatest(int[] nums2, Map<Integer, Integer> nextGreatest) {
        Stack<Integer> helperStack = new Stack<>();
        for (int i = nums2.length-1; i>= 0; i--){

            Integer support = nums2[i];

            while (!helperStack.isEmpty() && helperStack.peek() <= support) {
                helperStack.pop();
            }

            if(helperStack.isEmpty()){
                nextGreatest.put(support, -1);
            } else {
                nextGreatest.put( support, helperStack.peek());


            }
            helperStack.push(support);


        }


    }
}
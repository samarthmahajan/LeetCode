class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

         int start = 0;
        int end = 0;
        Set<Integer> seen = new HashSet<>();
        if(k==0)
            return false;
        while (end < nums.length) {
           if (seen.contains(nums[end])) {
               return true;
           }else  {
               if(end - start +1 > k) {
                   seen.remove(nums[start]);
                   start++;
               } else{

                   seen.add(nums[end]);
                   end++;
               }

           }
        }
        return false;
        
    }
}
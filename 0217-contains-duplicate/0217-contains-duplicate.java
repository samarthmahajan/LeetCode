class Solution {
    public boolean containsDuplicate(int[] nums) {
         Set<Integer> integers = new HashSet<>();
        for (int num: nums){
            if(Boolean.FALSE.equals(integers.add(num))){
                return true;
            }
        }
        return false;
        
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        

        // to revise  
        // step 1 create map wgich will check contains value 
        
           Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return Stream.of(new int[]{map.get(complement), i});
                    }
                    map.put(nums[i], i);
                    return Stream.empty();
                })
                .findFirst()
                .orElse(new int[]{-1, -1});
        
    }
}
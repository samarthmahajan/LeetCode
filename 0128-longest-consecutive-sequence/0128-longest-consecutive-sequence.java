class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int best = 0;
        for (int x : set) {
            if (set.contains(x + 1)) continue;       
            int len = 0;
            while (set.contains(x - len)) len++;     
            best = Math.max(best, len);
        }
        return best;

    }
}
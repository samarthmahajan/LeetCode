class Solution {
    public int longestSubstring(String s, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        s.chars().forEach(c -> map.put(c, map.getOrDefault(c,0)+1));
        for (int i=0; i < s.length(); i++) {
            if (map.get((int)s.charAt(i)) < k) {
        
                int countLeft = longestSubstring(s.substring(0,i), k);
                int countRight = longestSubstring(s.substring(i +1), k);
                return Math.max(countLeft, countRight);

            }
        }
        return s.length();
        
    }
}
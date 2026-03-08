class Solution {
    public String minWindow(String s, String t) {
         Map<Character, Long> map = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        String minString = "";
        //ADOBECODEBANC
        while (end < s.length()) {
            if(map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            }
            end++;
            while (map.values().stream().allMatch(c -> c <=0)) {
                if(end - start < min) {
                    minString = s.substring(start, end);
                    min = end - start;
                }
                if(map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                }
                start++;
            }
        }
        return minString;
        
    }
}
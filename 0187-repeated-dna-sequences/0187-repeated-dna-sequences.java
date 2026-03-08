class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        int windowSize = 10; // asked in ques of 10
        int start = 0;
        int end = windowSize ;

        for(; end <= s.length(); end++, start++) {
            String seq = s.substring(start, end);
             if(!seen.add(seq)) {
                 repeated.add(seq);
             }

        }

        return new ArrayList<>(repeated);

        
    }
}
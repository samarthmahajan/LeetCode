class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

         Map<String, Integer> frequencyMap = new HashMap<>();
        int windowSize = 10; // asked in ques of 10
        int start = 0;
        int end = windowSize ;

        for(; end <= s.length(); end++, start++) {
            frequencyMap.put(s.substring(start, end), frequencyMap.getOrDefault(s.substring(start, end), 0) + 1);

        }

        return frequencyMap.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

        
    }
}
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
                
        HashMap <String, Integer> map = new HashMap<>();
        
        List<String> words = Arrays.asList(s1.split(" "));
        words.stream().forEach(word -> {
            map.put(word, map.getOrDefault(word, 0) + 1);
        });
        
        List<String> words2 = Arrays.asList(s2.split(" "));
        words2.stream().forEach(word -> {
            map.put(word, map.getOrDefault(word, 0) + 1);
        });
        
        List<String> result = new ArrayList<>();
        
        map.entrySet().stream().forEach(entry -> {
            if(entry.getValue() == 1){
                result.add(entry.getKey());
            }
        });
        
        return  result.toArray(new String[0]);
    }
}
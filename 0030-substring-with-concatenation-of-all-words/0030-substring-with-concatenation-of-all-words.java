class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        

        Map<String, Integer> frequencyMap = Arrays.stream(words).collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
    int windowSize = words.length * words[0].length();
    int wordLen = words[0].length();
    List<Integer> result = new ArrayList<>();

    // 🔴 DELETED: The old loop that moved forward 1 single letter at a time
    // for (int i = 0; i <= s.length() - windowSize; i++) {
    //     Map<String, Integer> seen = new HashMap<>();
    //     int j = 0;
    //     while (j < words.length) { ... }
    //     if (j == words.length) { result.add(i); }
    // }

    // ---------------------------------------------------------
    // 🟢 NEW: The Optimized Caterpillar (Sliding Window)
    // ---------------------------------------------------------
    
    // 1. We only loop 'wordLen' times (e.g., 3 times) to set up our starting points.
    for (int i = 0; i < wordLen; i++) {
        
        // 2. Set up our caterpillar's head (right) and tail (left)
        int left = i;
        int right = i;
        int count = 0; // Tracks how many valid words we've eaten
        Map<String, Integer> seen = new HashMap<>();

        // 3. The caterpillar moves forward, jumping by whole words!
        while (right + wordLen <= s.length()) {
            
            // The head eats a word
            String word = s.substring(right, right + wordLen);
            right += wordLen; 

            // Did we eat a word we actually need?
            if (frequencyMap.containsKey(word)) {
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                // 4. Uh oh, we ate TOO MANY of this specific word!
                // Instead of starting over, pull the tail (left) forward until we drop the extra word.
                while (seen.get(word) > frequencyMap.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    count--;
                    left += wordLen; // Move tail forward
                }

                // 5. If our caterpillar is exactly the right size, we found a match!
                if (count == words.length) {
                    result.add(left);
                }
                
            } else {
                // 6. We ate a totally invalid word. The caterpillar dies and starts over here.
                seen.clear();
                count = 0;
                left = right; // Move the tail all the way to where the head is
            }
        }
    }

        return result;
    }
}
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
          // Step 1: Create a bitmask for the allowed characters
        int allowedMask = 0;
        for (char c : allowed.toCharArray()) {
            allowedMask |= (1 << (c - 'a')); // Set the bit for the character
        }
        
        int consistentCount = 0;

        // Step 2: Iterate through each word
        for (String word : words) {
            int wordMask = 0;
            for (char c : word.toCharArray()) {
                wordMask |= (1 << (c - 'a')); // Set the bit for the character
            }

            // Step 3: Check if wordMask is a subset of allowedMask
            if ((wordMask & allowedMask) == wordMask) {
                consistentCount++;  // If true, the word is consistent
            }
        }

        // Step 4: Return the count of consistent words
        return consistentCount;
    }
}
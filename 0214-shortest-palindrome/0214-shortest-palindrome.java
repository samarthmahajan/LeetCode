class Solution {
       public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // Step 1: Create the reversed version of the string
        String reverse = new StringBuilder(s).reverse().toString();
        
        // Step 2: Concatenate the original string, a separator, and the reversed string
        String newString = s + "#" + reverse;
        
        // Step 3: Build the KMP table for the concatenated string
        int[] kmpTable = buildKMPTable(newString);
        
        // Step 4: The value at the last position in the KMP table gives us the length of the longest palindromic prefix
        int longestPalindromicPrefixLength = kmpTable[kmpTable.length - 1];
        
        // Step 5: Determine the suffix that needs to be prepended by taking the substring that is not part of the palindrome
        String suffixToAdd = s.substring(longestPalindromicPrefixLength);
        
        // Step 6: Prepend the reverse of the suffix to the original string and return the result
        return new StringBuilder(suffixToAdd).reverse().toString() + s;
    }

    // Helper function to build the KMP prefix table
    private int[] buildKMPTable(String s) {
        int n = s.length();
        int[] table = new int[n];
        int j = 0;  // This tracks the length of the previous longest prefix suffix

        // Start iterating from the second character
        for (int i = 1; i < n; i++) {
            // Adjust j while characters do not match
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = table[j - 1];
            }
            // If we find a matching character, increment j
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            table[i] = j;  // Set the KMP table value for the current position
        }

        return table;
    }
    
}
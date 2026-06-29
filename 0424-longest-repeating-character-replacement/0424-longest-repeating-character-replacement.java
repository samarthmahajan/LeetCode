class Solution {

    public int characterReplacement(String s, int k) {
         int[] freq = new  int[26];
        int maxfequency = 0,  i = 0, res = 0;
        for (int j= 0; j<s.length(); j++){
            char c = s.charAt(j);
            freq[c - 'A']++;
            maxfequency = Math.max(maxfequency, freq[c - 'A']);
            while (j-i+1- maxfequency > k){
                char left = s.charAt(i);
                freq[left-'A']--;
                i++;
            }

            res = Math.max(res,j - i + 1 );
        }
        // your solution here
        return res;
    }
}
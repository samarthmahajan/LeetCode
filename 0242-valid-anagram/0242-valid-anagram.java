class Solution {
    public boolean isAnagram(String s, String t) {
          if (s.length() != t.length()) return false;
        int[] aphabet = new int[26];

        for (int i = 0 ; i<=s.length()-1; i++)
            aphabet[s.charAt(i)-'a']++;
        for (int i = 0 ; i<= t.length()-1; i++)
            aphabet[t.charAt(i)-'a']--;

        for (int i : aphabet) if (i != 0) return false;

        return true;

    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {


        if(s1.length()> s2.length())
            return  false;
        int[] count = new int[26];
        int win = s1.length();
        for (int x = 0; x < win; x++) {
            count[s1.charAt(x) - 'a']++;   // s1 contributes +1
            count[s2.charAt(x) - 'a']--;   // first window contributes -1
        }

        boolean allZeros = Arrays.stream(count).allMatch(x -> x == 0);

        int left = 0;
        while (left +win < s2.length() && !allZeros) {
            count[s2.charAt(left) - 'a']++;
            count[s2.charAt(left + win) - 'a']--;
            allZeros = Arrays.stream(count).allMatch(x -> x == 0);
            left++;

        }

        return allZeros;
        
    }
}
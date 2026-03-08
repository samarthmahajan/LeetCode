class Solution {
    public int lengthOfLongestSubstring(String s) {

         char[] charArray = s.toCharArray();
        int size = charArray.length;
        int start = 0;
        int end = 0;
        int maxLength = 0;



        Set<Character> set = new HashSet<>();

       while (end < size) {
           if (!set.contains(charArray[end])) {
               set.add(charArray[end]);
               end++;
               maxLength = Math.max(maxLength, end - start);
           }else {

               if(set.contains(charArray[start])) {
                   set.remove(charArray[start]);
               }
               start ++;

           }
       }
       return maxLength;

    }

}
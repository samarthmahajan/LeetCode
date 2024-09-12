class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
          int countWord = 0;
        Set<Character> alowedCharacters = allowed.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        for (String word : words) {

            boolean isConsistent = true; 
            for (char c : word.toCharArray()) {
                if (!alowedCharacters.contains(c)) {
                    isConsistent = false ;
                     break;
                    }



            }
              if (isConsistent) {
                        countWord++;
                    }
        }

        return countWord;
    }
}
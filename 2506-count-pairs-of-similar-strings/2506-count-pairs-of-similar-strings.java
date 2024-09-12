class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> bitmaskFrequency = new HashMap<>();
        int similarPairsCount = 0;
        
        for (String word : words) {
            int bitMask = buildBitMas(word);
            int similarWordCount = bitmaskFrequency.getOrDefault(bitMask, 0);
            similarPairsCount += similarWordCount;
            bitmaskFrequency.put(bitMask, similarWordCount + 1);
        }
        return similarPairsCount;
        

    }

    private static int buildBitMas(String string){
        int bitMask = 0;
        for (char c : string.toCharArray()) {
            int valueBetweenZeroAndTwentyFive = c - 'a';
            int whereShouldTheFistbitLie= 1 << valueBetweenZeroAndTwentyFive;
            bitMask |= whereShouldTheFistbitLie;
        }
        return bitMask;
    }
}
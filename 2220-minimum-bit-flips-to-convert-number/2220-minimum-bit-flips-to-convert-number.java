class Solution {
    public int minBitFlips(int start, int goal) {

            int xorRes = start ^ goal; // what this do is convert and create the xor result, that means  all the bits which are different are represented as 1.
        return Integer.bitCount(xorRes);
    }
}

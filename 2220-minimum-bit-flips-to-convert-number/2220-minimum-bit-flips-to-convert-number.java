class Solution {
    public int minBitFlips(int start, int goal) {

            int xorRes = start ^ goal; // what this do is convert and create the xor result by thaat what i mean is all the bits which are different are as one
        return Integer.bitCount(xorRes);
    }
}
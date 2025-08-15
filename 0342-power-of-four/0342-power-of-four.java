class Solution {
    public boolean isPowerOfFour(int n) {

        if (n == 1) return true;   // handle 4^0 case
        if (n <= 0 || n % 4 != 0) return false;

        return isPowerOfFour(n/4);
    }
}
class Solution {
    public String removeKdigits(String num, int k) {
        // If we have to remove all digits, the result is 0
        if (k == num.length()) {
            return "0";
        }

        StringBuilder stack = new StringBuilder();

        for (char c : num.toCharArray()) {
            // The Greedy Choice:
            // While we still have removals left (k > 0)
            // AND the stack is not empty
            // AND the last digit we kept is LARGER than the current digit
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1); // Pop the larger digit
                k--;
            }
            stack.append(c); // Push the current digit
        }

        // Edge Case 1: The digits were already in increasing order (e.g., "112")
        // If k > 0, we just chop off the largest numbers at the end
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Edge Case 2: Remove any leading zeros
        int startIndex = 0;
        while (startIndex < stack.length() && stack.charAt(startIndex) == '0') {
            startIndex++;
        }

        String result = stack.substring(startIndex);

        // If we stripped all characters (e.g., input was "10", k=1 -> "0"), return "0"
        return result.isEmpty() ? "0" : result;
        
    }
}
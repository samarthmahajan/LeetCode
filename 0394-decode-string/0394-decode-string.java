class Solution {
    public String decodeString(String s) {
          Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Handle multi-digit numbers (e.g., 12 or 100)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current count and current string to their respective stacks
                countStack.push(k);
                stringStack.push(currentString);

                // Reset for the content inside the brackets
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Decode the current segment
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();

                // Repeat the currentString currentK times and append to the popped base
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // Normal character, just append to the active string
                currentString.append(ch);
            }
        }

        return currentString.toString();
        
    }
}
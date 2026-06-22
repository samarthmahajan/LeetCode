class Solution {
    public int calculate(String s) {

          Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;          // the number currently being built, digit by digit
        char prevOp = '+';    // operator BEFORE num; '+' simulates a leading +

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');   // fold next digit in (multi-digit safe)
            }

            // Act when we hit an operator OR the final char (the last number has
            // no operator after it, so end-of-string is its trigger).
            // A space is neither digit nor operator -> it falls through, skipped.
            boolean isOperator = (c == '+' || c == '-' || c == '*' || c == '/');
            if (isOperator || i == s.length() - 1) {
                switch (prevOp) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);  // popped = LEFT operand
                    case '/' -> stack.push(stack.pop() / num);  // popped / num
                }
                prevOp = c;   // remember THIS operator for the next number
                num = 0;      // reset accumulator
            }
        }

        // Everything on the stack is a +/- adjusted term -> just sum them.
        int result = 0;
        for (int term : stack) {
            result += term;
        }
        return result;
        
    }
}
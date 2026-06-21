class Solution {
    
    private static final Map<String, DoubleBinaryOperator> OPERATORS = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            }
    );

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String val : tokens){
            if(val != null && val.matches("-?\\d+")){
                stack.push(Integer.parseInt(val));
            } else {
                Integer lat=stack.pop();
                Integer first=stack.pop();
                DoubleBinaryOperator op = OPERATORS.get(val);
                Double res = op.applyAsDouble( first, lat);
                stack.push(res.intValue());

            }
        }
        return stack.pop();

    }
}
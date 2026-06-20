class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            // While we have a collision (right-mover on top, left-mover current)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                // If the top (right-mover) is smaller, it gets destroyed
                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                    stack.pop();
                    continue; // Check the next asteroid in the stack
                }
                // If they are equal size, both get destroyed
                else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    stack.pop();
                    destroyed = true;
                    break;
                }
                // If the top is larger, the current asteroid is destroyed
                else {
                    destroyed = true;
                    break;
                }
            }

            // If the incoming asteroid wasn't destroyed, add it to the stack
            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert to int array
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
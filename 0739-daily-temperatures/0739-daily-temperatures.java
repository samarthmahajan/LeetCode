class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         ArrayDeque<Integer> highTempMonotonicStack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i= temperatures.length -1 ; i>=0; i--){
            int temperature = temperatures[i];
            while (!highTempMonotonicStack.isEmpty() && temperatures[highTempMonotonicStack.peek()]<= temperature)
                highTempMonotonicStack.pop();
            if(!highTempMonotonicStack.isEmpty())
                result[i]=highTempMonotonicStack.peek()-i;
            else
                result[i]=0;
            highTempMonotonicStack.push(i);
        }

        return result;
    }
}
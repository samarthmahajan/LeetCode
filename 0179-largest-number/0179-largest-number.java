class Solution {
    public String largestNumber(int[] nums) {
         // Convert integers to strings
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        
        // Sort the strings based on custom comparator
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Sort in descending order
            }
        });
        
        // If the largest number is "0", return "0"
        if (numsStr[0].equals("0")) {
            return "0";
        }
        
        // Join the sorted numbers to form the largest number
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numStr : numsStr) {
            largestNumberStr.append(numStr);
        }
        
        return largestNumberStr.toString();
    }
}
class Solution {
    public int maxProfit(int[] prices) {

           int left=0, right = 1, max =0;
       while (right< prices.length){
           int profit = prices[right]- prices[left];
           if (profit<=0){
               left=right;
               right++;
           } else {
               right++;
               max = Math.max(max, profit);
           }
       }

       return max;
        
    }
}
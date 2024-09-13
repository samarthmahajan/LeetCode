class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] xorArr = new int[arr.length];
        xorArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xorArr[i] = xorArr[i-1] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 0){
                result[i] = xorArr[right];
            }else{
                result[i] = xorArr[right] ^ xorArr[left-1];
            }
        }
        return result;

            
        }
}
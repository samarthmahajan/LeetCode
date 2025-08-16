class Solution {
    public String largestGoodInteger(String num) {

        var chars = num.toCharArray();
        int pointer = 2;
        String maxval = "";

        for (int i = 0, j = 1; j < chars.length; j++) {
            if (chars[i] == chars[j] && pointer > 0) {
                pointer--;
            } else {
                i = j;
                pointer = 2;
            }
            if (pointer == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(chars[i]).append(chars[i]).append(chars[i]);
                String val = stringBuilder.toString();
                System.out.println(val);
                Integer value = Integer.valueOf(val);
                Integer max = Integer.valueOf(maxval == "" ?  "0" : maxval);
                if (value >= max){
                    maxval = val;
                    
                }
                pointer = 2;

            }
        }
        return maxval;

    }
}
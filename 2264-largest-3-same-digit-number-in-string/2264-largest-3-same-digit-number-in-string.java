class Solution {
    public String largestGoodInteger(String num) {

        char[] s = num.toCharArray();

        int n = s.length;
        char best = 0; // sentinel: no triple found yet

        for (int i = 0; i + 2 < n; i++) {
            char c = s[i];
            if (c == s[i + 1] && c == s[i + 2]) {
                if (c > best) {
                    best = c;
                    if (best == '9')
                        return "999"; // can't beat this
                }
                // optional skip to avoid re-checking long runs like '77777'
                int j = i + 3;
                while (j < n && s[j] == c)
                    j++;
                i = j - 3; // next i will be j-2 after the loop increment
            }
        }
        return best == 0 ? "" : String.valueOf(best).repeat(3);

    }
}
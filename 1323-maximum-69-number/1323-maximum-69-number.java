class Solution {
    public int maximum69Number(int num) {
        int len = (int) Math.log10(num) + 1;
        List<Integer> intList = new ArrayList<>(len);
        for (int i = 0 ; i <len; i++) {
            int rem = num % 10;
            intList.add(i, rem);
            num /= 10;
        }

        Collections.reverse(intList);

        for (int i = 0; i < len; i++) {
            if (intList.get(i) == 6) {
                intList.remove(i);
                intList.add(i, 9);
                break;
            }

        }
        return Integer.parseInt(intList.stream()
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining()));
    }
}
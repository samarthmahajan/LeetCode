class Solution {
    public int[] topKFrequent(int[] nums, int k) {
           Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);

        List<Integer>[] buckets = new ArrayList[nums.length + 1];   // index = frequency
        for (var e : freq.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(e.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for (int val : buckets[i]) {
                result[idx++] = val;
                if (idx == k) break;
            }
        }
        return result;
    }
}
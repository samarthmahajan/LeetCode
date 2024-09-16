class Solution {
    public int findMinDifference(List<String> timePoints) {
          // Step 1: Convert all time points into minutes
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + mins;
            minutes.add(totalMinutes);
        }

        // Step 2: Sort the list of minutes
        Collections.sort(minutes);

        // Step 3: Find the minimum difference between consecutive time points
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            minDifference = Math.min(minDifference, minutes.get(i) - minutes.get(i - 1));
        }

        // Step 4: Handle the wrap-around case (difference between the first and last time points)
        int wrapAroundDiff = 1440 - minutes.get(minutes.size() - 1) + minutes.get(0); // 1440 is the total minutes in 24 hours
        minDifference = Math.min(minDifference, wrapAroundDiff);

        return minDifference;
    }
}
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        long sum = 0;
        double avg = 0;
        double maxAvg = Integer.MIN_VALUE;

        for(j = 0;j < k;j++) {
            sum += nums[j];
        }

        avg = (double) sum / k;
        maxAvg = Math.max(avg,maxAvg);

        for(j = k; j < nums.length; j++) {
            sum -= nums[i];
            sum += nums[j];

            i++;

            avg = (double) sum / k;
            maxAvg = Math.max(avg,maxAvg);
        }

        return maxAvg;
    }
}
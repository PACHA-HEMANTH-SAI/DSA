class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        long sum = 0;
        double max = Double.NEGATIVE_INFINITY;

        for(j = 0;j < k;j++) {
            sum += nums[j];
        }

        max = Math.max(sum,max);

        for(j = k; j < nums.length; j++) {
            sum -= nums[i];
            sum += nums[j];

            i++;

            max = Math.max(max,sum);
        }

        return max / (double) k;
    }
}
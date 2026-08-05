class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int j = 0;j < nums.length;j++) {
            sum += nums[j];

            while(i <= j && sum >= target) {
                min = Math.min(j - i + 1, min);
                sum -= nums[i];
                i++;
            }
            
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
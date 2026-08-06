class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length;i++) {
           set.add(nums[i]);
           min = Math.min(nums[i], min);
           max = Math.max(nums[i], max);
        }

        for(int i = min;i <= max;i++) {
            if(set.contains(i)) continue;
            ans.add(i);
        }

        Collections.sort(ans);
        return ans;
    }
}
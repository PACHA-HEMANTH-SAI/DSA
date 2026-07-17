class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> l = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0;i <= (n-3);i++) {

            if(i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while(j < k) {

            if((nums[i] + nums[j] + nums[k]) == 0) {
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                l.add(new ArrayList<>(list));
                list.clear();

                j++;
                k--;
                while(j < k && nums[j] == nums[j - 1]) j++;
                while(k > j && nums[k] == nums[k + 1]) k--;
            }

            else if(k > j && ((nums[i] + nums[j] + nums[k]) > 0)) {
                k--;
            }

            else if(j < k && (nums[i] + nums[j] + nums[k]) < 0) {
                j++;
            }

            }

        }

        return l;
    }
}
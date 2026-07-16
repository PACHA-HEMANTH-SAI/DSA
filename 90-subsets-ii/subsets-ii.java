class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        generateSubsets(nums, 0, list, l);
        return list;
    }

    public void generateSubsets(int[] nums, int ind, List<List<Integer>> list, List<Integer> l) {
        if(ind == nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[ind]);
        generateSubsets(nums, ind + 1, list, l);
        l.remove(l.size() - 1);
        int temp = ind + 1;
        while(temp < nums.length && nums[ind] == nums[temp]) {
            temp++;
        }
        generateSubsets(nums, temp, list, l);
    }
}
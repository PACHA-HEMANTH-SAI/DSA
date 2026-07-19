class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        generateCombinations( n, 1, k, list, l);

        return list;
    }

    public void generateCombinations(int n, int ind, int k, List<List<Integer>> list, List<Integer> l) {
        if(l.size() == k) {
            list.add(new ArrayList<>(l));
            return;
        }

        else if(ind == (n + 1)) {
            if(l.size() == k) list.add(new ArrayList<>(l));
            return;
        }

        if((l.size() + n - ind) >= k) generateCombinations(n, ind + 1, k, list, l);
        l.add(ind);
        generateCombinations(n, ind + 1, k, list, l);
        l.remove(l.size() - 1);
    }
}
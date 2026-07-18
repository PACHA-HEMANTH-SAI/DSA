class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        List<List<String>> ans = new ArrayList<>();
       
        for(int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
            if(map.containsKey(temp)) {
                map.get(temp).add(strs[i]);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(temp,l);
            }
        }

        for(var e : map.entrySet()) {
            ans.add(e.getValue());
        }

        return ans;

    }
}
class Solution {
    public String smallestSubsequence(String s) {
        int visited[] = new int[26];
        int freq[] = new int[26];
        Stack<Character> stack = new Stack<>();

        for( int i = 0; i < s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0;i < s.length();i++) {
            freq[s.charAt(i) - 'a']--;

            if(visited[s.charAt(i) - 'a'] == 1) {
                continue;
            }

            while(!stack.isEmpty() && (stack.peek() > s.charAt(i)) && freq[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = 0;
                stack.pop();
            }

            stack.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = 1;
        }

        StringBuffer sb = new StringBuffer("");

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
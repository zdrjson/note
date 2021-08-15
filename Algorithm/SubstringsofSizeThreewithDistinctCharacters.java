// Solution: Brute Force w/ (Hash)Set
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i + 2 < s.length(); ++i) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            set.add(s.charAt(i + 1));
            set.add(s.charAt(i + 2));
            ans += set.size() == 3 ? 1 : 0; // 这里三目运算符整个表达式可以不加括号。
        }
        return ans;
    }
}

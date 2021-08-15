class Solution {
public:
    int countGoodSubstrings(string s) {
        int ans = 0;
        for (int i = 0; i + 2 < s.length(); ++i)
            ans += set<char>(s.begin() + i, s.begin() + i + 3).size() == 3;
        return ans;
    }
};

// // 花花blog中的代码
// class Solution {
// public:
//     int stoneGameVIII(vector<int>& stones) {
//         const int n = stones.size();
//         for (int i = 1; i < n; ++i)
//             stones[i] += stones[i - 1];
//         int ans = stones.back(); // take all the stones.
//         for (int i = n - 2; i > 0; --i)
//             ans = max(ans, stones[i] - ans);
//         return ans;
//     }
// };

// 花花视频中的代码
class Solution {
public:
    int stoneGameVIII(vector<int>& stones) {
        const int n = stones.size();
        for (int i = 1; i < n; ++i)
            stones[i] += stones[i - 1];
        int ans = stones.back(); // dp[n]
        for (int i = n - 1; i >= 2; --i)
            ans = max(ans, stones[i - 1] - ans);
        return ans;
    }
};

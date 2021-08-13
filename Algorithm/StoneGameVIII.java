// Solution: Prefix Sum + DP
// Note: Naive DP (min-max) takes O(n^2) which leads to TLE. The key of this problem is that each player takes k stones, but put their sum back as a new stone, so you can assume all the original stones are still there, but opponent has to start from the k+1 th stone.
// Let dp[i] denote the max score diff that current player can achieve by taking stones[0~i] (or equivalent)
// dp[n-1] = sum(A[0~n-1]) // Alice takes all the stones.
// dp[n-2] = sum(A[0~n-2]) - A([n-1] + sum(A[0~n-2])) = sum(A[0~n-2]) - dp[n-1] // Alice takes n-1 stones, Bob takes the last one (A[n-1]) + put-back-stone.
// dp[n-3] = sum(A[0~n-3]) - max(dp[n-2], dp[n-1]) // Alice takes n-2 stones, Bob has two options (takes n-1 stones or takes n stones)
// ...
// dp[0] = A[0] - max(dp[n-1], dp[n-1], ..., dp[1]) // Alice takes the first stone, Bob has n-1 options.
// Time complexity: O(n)
// Space complexity: O(1)
// 花花blog中的代码
// class Solution {
//     public int stoneGameVIII(int[] stones) {
//         final int n = stones.length;
//         for (int i = 1; i < n; ++i)
//             stones[i] += stones[i - 1];
//         int ans = stones[n - 1]; // takes all the stones.
//         for (int i = n - 2; i > 0; --i)
//             ans = Math.max(ans, stones[i] - ans);
//         return ans;
//     }
// }

// 花花视频中的代码
class Solution {
    public int stoneGameVIII(int[] stones) {
        final int n = stones.length;
        for (int i = 1; i < n; ++i)
            stones[i] += stones[i - 1];
        int ans = stones[n - 1]; // dp[n]
        for (int i = n - 1; i >= 2; --i)
            ans = Math.max(ans, stones[i - 1] - ans);
        return ans;
    }
}

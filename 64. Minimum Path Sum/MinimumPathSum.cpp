class Solution {
public:
    int solve(vector<vector<int>>& grid, vector<vector<int>>& memo, int i, int j) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return INT_MAX;
        if (memo[i][j] != -1) return memo[i][j];
        memo[i][j] = grid[i][j] + min(solve(grid, memo, i - 1, j), solve(grid, memo, i, j - 1));
        return memo[i][j];
    }
    
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> memo(m, vector<int>(n, -1));
        return solve(grid, memo, m - 1, n - 1);
    }
};

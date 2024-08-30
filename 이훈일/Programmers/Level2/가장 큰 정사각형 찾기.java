class Solution{
    public static int solution(int [][]board) {
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                dp[i+1][j+1] = board[i][j];
            }
        }
        
        int max = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(dp[i][j] == 1) {
                    int left = dp[i][j-1];
                    int up = dp[i-1][j];
                    int diagonal = dp[i-1][j-1];
                    
                    dp[i][j] = Math.min(left, Math.min(up, diagonal)) + 1;
                    
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
}

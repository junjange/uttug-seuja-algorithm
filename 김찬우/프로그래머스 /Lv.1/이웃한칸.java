class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        String color = board[h][w];
        int count = 0;
        
        for(int i=0; i<4; i++){
            
            int nx = h+dx[i];
            int ny = w+dy[i];
            
            if(nx < 0 || nx > board.length-1 || ny < 0 || ny > board.length-1){
                continue;
            }
            
            if(board[nx][ny].equals(color)){
                count++;
            }
            
            
            
        }
        
        
        
        
        return count;
    }
}

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        List<Integer> basket = new ArrayList<Integer>();
        
        for(int i : moves) {
            for(int j = 0; j < board.length; j++) {
                int boardData = board[j][i-1];
                if(boardData > 0) {
                    if(basket.size() > 0) {
                        int lastData = basket.get(basket.size()-1);
                        if(lastData == boardData) {
                            basket.remove(basket.size()-1);
                            count += 2;
                        }else {
                            basket.add(boardData);
                        }
                    }else {
                        basket.add(boardData);
                    }
                    board[j][i-1] = 0;
                    break;
                }
            }
        }
        
        return count;
    }
}

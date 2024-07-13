import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                if(i1[col-1] == i2[col-1]) {
                    return i2[0] - i1[0];
                }
                
                return i1[col-1] - i2[col-1];
            }
        });
        
        int result = 0;
        for(int i = row_begin-1; i < row_end; i++) {
            int mod = 0;
            
            for(int j = 0; j < data[i].length; j++) {
                mod += data[i][j] % (i+1);
            }
            
            result = result ^ mod;
        }
        
        return result;
    }
}

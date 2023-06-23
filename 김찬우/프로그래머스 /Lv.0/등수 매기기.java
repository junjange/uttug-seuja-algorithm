import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[][] score) {
        
        int[] result = new int[score.length];
         int[] answer = new int[score.length];
        
        for(int i=0; i<score.length; i++){
            
            result[i] = score[i][0]+ score[i][1];
        }
        
        // result = Arrays.stream(result).distinct().toArray();
        
        Integer[] vt = Arrays.stream(result).boxed().toArray(Integer[]::new);
        
        Arrays.sort(vt, Collections.reverseOrder());
        
        for(int j =0; j<score.length; j++){
            
            answer[j] = Arrays.asList(vt).indexOf(score[j][0]+score[j][1])+1;
        
        }
        
        return answer;
    }
}

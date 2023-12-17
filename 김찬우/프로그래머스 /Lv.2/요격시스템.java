import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(int[][] targets) {
        
        int result = 1;
       
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] x1, int[] x2) {
                return x1[0] - x2[0];
            }
        });
        
        int left = targets[0][0];
        int right = targets[0][1];
        
        
        for(int i = 1; i<targets.length; i++){
            
            int compareLeft = targets[i][0];
            int compareRight = targets[i][1];
            
            
            if(left <= compareLeft && compareLeft < right){
                left = Math.max(left,compareLeft);
                right = Math.min(right,compareRight);
            }
            else{
                left = compareLeft;
                right = compareRight;
                result++;
            }
        }
        
        

        return result;
    }
    

}

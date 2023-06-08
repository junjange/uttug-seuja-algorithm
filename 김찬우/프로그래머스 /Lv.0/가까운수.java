import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

class Solution {
    public int solution(int[] array, int n) {
        
        Integer[] arr = Arrays.stream(array).boxed().toArray(Integer[]::new);
        
         Arrays.sort(arr, Collections.reverseOrder());
        
        int[] finalArr = Arrays.stream(arr).mapToInt(i->i).toArray();
        
        int answer = 100;
        int index = 0;
        
      
        
        for(int i = 0; i < finalArr.length; i++){
            
            int gap = Math.abs(finalArr[i]-n);
            
            if(gap<=answer){
                
                answer=gap;
                index = i;
            }
            
            
        }
        return finalArr[index];
    }
}

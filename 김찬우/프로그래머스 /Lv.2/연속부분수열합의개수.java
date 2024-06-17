import java.util.*;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] elements) {
        
       int[] list =  new int[elements.length * 2];
        
        HashSet<Integer> result = new HashSet<>();
        
        for(int i=0; i<elements.length; i++){
            
            list[i + elements.length] = elements[i];
            list[i] = elements[i];
                
        }
        
        for(int i = 1; i < elements.length; i++ ){
            
            for(int j = 0 ; j < elements.length; j++){
                int num = Arrays.stream(list,j, j+i).sum();
                result.add(num);
            }
            
        }
        
        
        return result.size()+1;
    }
}

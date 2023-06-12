import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers, int k) {
        
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        
        for(int i =0; i<=k;i++){
            
            for(int numInt : numbers){
            
                list.add(numInt);
            }
            
        }
    
    
       return list.get(2*k-2);
    }
}

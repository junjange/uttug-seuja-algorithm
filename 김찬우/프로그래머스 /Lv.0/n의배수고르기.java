import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
         List<Integer> intList = new ArrayList<>();
        
        for(int num:numlist){
            
            if(num%n==0){
                intList.add(num);
            }
        }
    
        return intList.stream().mapToInt(i -> i).toArray();


        }
}


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        
         List<Integer> intList  = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        int index = intList.indexOf(Collections.min(intList));
        
        intList.remove(index);
        
        if(intList.size()==0){
            return new int[]{-1};
        }
        else{
            return  intList.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

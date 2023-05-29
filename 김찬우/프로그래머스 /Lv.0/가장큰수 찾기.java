import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array) {
                
        List<Integer> intList = Arrays.stream(array).boxed().collect(Collectors.toList());
        int max = intList.stream().mapToInt(x -> x).max().getAsInt();
        int index = intList.indexOf(max);
        
        
        return new int[] {max,index};
    
    }
}

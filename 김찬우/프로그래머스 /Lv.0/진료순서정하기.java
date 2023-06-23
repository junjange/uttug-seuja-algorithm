import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] emergency) {
        
        int[] copyList = Arrays.copyOf(emergency,emergency.length);
        
        Integer[] arr = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        return Arrays.stream(emergency).map(e -> Arrays.asList(arr).indexOf(e)+1).toArray();
    }
}

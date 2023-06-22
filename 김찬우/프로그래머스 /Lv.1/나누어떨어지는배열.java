import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int[] intArr = Arrays.stream(arr).filter(a -> a % divisor ==0).toArray();
        
        Arrays.sort(intArr);
        
        int[] ex = new int[]{-1};
        
        return intArr.length==0? ex: intArr;
    }
}

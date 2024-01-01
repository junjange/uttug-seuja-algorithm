import java.util.*;

public class Solution {
    public int solution(int n) {
        int result = 1;
        while(n != 1) {
            if(n % 2 != 0) {
                result++;
            }
            
            n = n / 2;
        }
        
        return result;
    }
}

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int result = arr[arr.length - 1];
        for(int i = arr.length-2; i >= 0; i--) {
            result = lcm(result, arr[i]);
        }
        
        return result;
    }
    
    static int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
    
    static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}

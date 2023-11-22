import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0;
        int j = 0;
        int count = 0;
        while(j < B.length) {
            if(A[i] < B[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            } 
        }
        
        return count;
    }
}

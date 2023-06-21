import java.util.ArrayList;
import java.util.List;

class Solution {
    public long[] solution(int x, int n) {
        
        long[] longList = new long[n];
        
        long i = x;
        int j = 0;
        
        while(j<n){
            
            longList[j]=i;
            i=i+x;
            j++;
        }
        

        return longList;
    }
}

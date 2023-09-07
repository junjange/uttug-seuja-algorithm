import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        
        List<Integer> fibo = new ArrayList<Integer>();
        int result =0;
        fibo.add(0);
        fibo.add(1);
       
        for(int i = 2; i<=n; i++){
            
            result = fibo.get(i-2)+fibo.get(i-1);
            
            fibo.add(result%1234567);
            
        }
        
        
        
      return  fibo.get(n);
        
    }
}

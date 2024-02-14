import java.util.*;
class Solution {
    public String solution(int n) {
        StringBuilder sb =  new StringBuilder();
        String[] arr = {"4","1","2"};
        
        while(n != 0){
            
            if(n%3==0){
                sb.append(arr[0]);
                n = (n/3)-1;
            }else{
                 sb.append(arr[n%3]);
                n/=3;
            }
            
        }
        
        
        
        return sb.reverse().toString();
    }
}

import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        
        long[] arr = new long[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++){
            sb.setLength(0);
            
            
            long a = numbers[i];
          
            if(a%2==0){
                arr[i] = a+1;
                continue;
            }
            
            sb.append(Long.toBinaryString(a));
            
            
            if(sb.indexOf("0") ==-1){
                 sb.insert(0,"0");
            }
            
           
            
            int index = sb.lastIndexOf("01");
            
            String result = sb.substring(0,index) + "10" + sb.substring(index+2);
            
            arr[i] = Long.parseLong(result, 2);
            
            
            
        }
        
        
        


        return arr;
    }
}

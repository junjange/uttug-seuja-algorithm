import java.util.*;
class Solution {

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int i = 0; 
        
        Loop1 :
        while(true){
            
            String str = radix(i,n);

            for(int j=0; j<str.length(); j++){
                
                sb.append(str.charAt(j));
                
                if(sb.length() >= t*m){
                    break Loop1;
                }
                
            }
            
            i++;
            
            
        }
        

        
        for(int k = p-1; k < sb.length(); k+=m){
            
            answer+= sb.charAt(k);
            
        }
        
        return answer;
    }
    
    public String radix(int num , int rdd){
        
        StringBuilder stb =  new StringBuilder();
        
        if(num ==0){
            return "0";
        }
        
        while(num>0){
            
            if(num % rdd < 10){
                stb.append(num % rdd);
            }else{
                stb.append((char)(num % rdd - 10 + 'A'));
            }
            
            num /= rdd;
            
        }
        
        return stb.reverse().toString();
        
        
    }
    
    
    
    
}

import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
    
        String result = "";
        StringBuilder sb = new StringBuilder();
        
        for(char i = 'a'; i<='z'; i++){
            
            if(skip.contains(i+"")){
                continue;
            }else{
                result+=i;
            }
        }
        
        for(int i=0; i<s.length(); i++){
            
            int strIndex = result.indexOf(s.charAt(i));
            int a = (strIndex+index)%result.length();
            sb.append(result.charAt(a));
        }
        
        
        return sb.toString();
    }
}

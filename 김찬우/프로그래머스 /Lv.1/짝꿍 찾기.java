
import java.util.Arrays;
import java.lang.Math;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
    
        
        for(int i=0; i<=9; i++){
            
            int xNum = X.length()-X.replace(String.valueOf(i),"").length();
            int yNum = Y.length()-Y.replace(String.valueOf(i),"").length();
            
            if(xNum==0 || yNum==0){
                continue;
            }
            
            answer+= String.valueOf(i).repeat(Math.min(xNum, yNum));
            
            // if(xNum > yNum){
            //     answer+= String.valueOf(i).repeat(yNum);
            // }
            // else{
            //      answer+= String.valueOf(i).repeat(xNum);
            // }
            

        }
        
        char[] chars = answer.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(new String(chars,0,chars.length));
        String result = sb.reverse().toString();
        
        
        if(result.equals("")){
            return "-1";
        }   
        
        if(result.charAt(0)=='0'){
            return "0";
        }
        
        return result;
    }
}

import java.lang.Math;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] x = new int[10];
        int[] y = new int[10];
        
        for(int i=0; i<X.length(); i++){
            x[X.charAt(i)-'0']+=1;
        }
        
         for(int i=0; i<Y.length(); i++){
            y[Y.charAt(i)-'0']+=1;
        }
        
        for(int i=9; i>-1; i--){
            
            int min = Math.min(x[i],y[i]);
            
            if(min == 0){
                continue;
            }else{
                answer+= String.valueOf(i).repeat(min);
            }
            
            
        }
        
        if(answer.equals("")){
            answer = "-1";
        }else if(answer.replace("0","").length() == 0){
            answer = "0";
        }
        
        
        
        return answer;
    }
}

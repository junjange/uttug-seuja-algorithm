import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        
        String num ="";
    
        int result = 0;
        int now = 0;
        
        List<Integer> score = new ArrayList<Integer>();  
        
        for(int i =0; i<dartResult.length();i++){
            
            if(dartResult.charAt(i)=='S'){
                
                
                int intNum = Integer.valueOf(num);
                now = intNum;
                score.add(now);
                result+=now;
                num="";
                
                
                
            }else if(dartResult.charAt(i)=='D'){
                
                int intNum = Integer.valueOf(num);
                now = intNum*intNum;
                score.add(now);
                result+=now;
                num="";
                  
                
            }else if(dartResult.charAt(i)=='T'){
                
                int intNum = Integer.valueOf(num);
                now = intNum*intNum*intNum;
                score.add(now);
                result+=now;
                num="";
                
            }else if(dartResult.charAt(i)=='*'){
                
                if(i==2 || i==3){
                    
                    result+=score.get(0);
                    score.set(0, score.get(0)*2);
                    
                }else{
                    
                    int scoreLen = score.size();
                    
                    
                    result+= score.get(scoreLen-1)+score.get(scoreLen-2);
                    
                    score.set(scoreLen-1, score.get(scoreLen-1)*2);
                    score.set(scoreLen-2, score.get(scoreLen-2)*2);
            
                    
                }
                
                
            }else if(dartResult.charAt(i)=='#'){
                
                
                result+= score.get(score.size()-1)*-2;
                
                score.set(score.size()-1, score.get(score.size()-1)*-1);
            
                
            }else{
                num+=dartResult.charAt(i);
            }
            
            
        }
        
       
        return result;
    }
}

import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] talk = {"aya", "ye", "woo", "ma"};
        
        for(int i =0; i<babbling.length; i++){
            
            for(int j=0; j<talk.length; j++){
                
                if(babbling[i].indexOf(talk[j].repeat(2))==-1){
                    
                    babbling[i] = babbling[i].replace(talk[j],"*");
                    
                }


            }  
            
             babbling[i]=babbling[i].replace("*","");

 
        }
        
        
        
         
        for(String a :babbling){
            
            System.out.println(a);
            
            if(a.equals("")){
                answer+=1;
            }

        }
        
        
        return answer;
    }
}

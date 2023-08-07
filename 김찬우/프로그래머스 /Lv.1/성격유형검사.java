import java.util.*;
import java.lang.Math;


class Solution {
    public String solution(String[] survey, int[] choices) {
        
          HashMap<String, Integer> map = new HashMap<>();
        
        String result ="";
        
        map.put("R",0);
        map.put("T",0);
        map.put("C",0);
        map.put("F",0);
        map.put("J",0);
        map.put("M",0);
        map.put("A",0);
        map.put("N",0);
        
        for(int i=0; i<survey.length; i++){
            
            if(choices[i]>4){
                
                int a = map.get(Character.toString(survey[i].charAt(1)));
                System.out.println("a"+a);
                map.put(Character.toString(survey[i].charAt(1)),(a+choices[i]-4));
                
                
            }
            else if(choices[i]==4){
                 continue;
                
            }else{
                
                 int b = map.get(Character.toString(survey[i].charAt(0)));
                
                 map.put(Character.toString(survey[i].charAt(0)), (b + 4-choices[i]));
                
                 System.out.println("b"+b);
             }
        
            
        }
        
        if(map.get("R")<map.get("T")){
            
           result+="T";
        }
        else{
           result+="R";
        }
        
        if(map.get("C")<map.get("F")){
           result+="F";
        }
        else{
            result+="C";
        }
        
        if(map.get("J")<map.get("M")){
           result+="M";
        }else{
             result+="J";
        }
        
        if(map.get("A")<map.get("N")){
           result+="N";
        }else{
            result+="A";
        }
        
    
        return result;
    }
}

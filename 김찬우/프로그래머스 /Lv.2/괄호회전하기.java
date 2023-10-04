import java.util.*;

class Solution {
    public int solution(String s) {
        
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            Stack<Character> stack = new Stack<>(); 
            
            StringBuilder nextStr =  new StringBuilder(s);
            String subStr = nextStr.substring(0,i);
            nextStr.delete(0,i);
            nextStr.append(subStr);
            
            
            for(int j = 0; j<s.length(); j++){
                
                char word = nextStr.charAt(j);

                if(stack.empty()){
                    stack.push(word);
                    continue;
                }
                
                char peek = stack.peek();
                
                if(peek == '[' && word ==']'){
                    stack.pop();
                }
                else if(peek == '(' && word ==')'){
                    stack.pop();
                }
                else if(peek == '{' && word =='}'){
                    stack.pop();
                }
                else{
                    stack.push(word);
                }
                
            }
            
             if(stack.empty()){
                 count++;
             }

        }
        
       
        
        return count;
    }
}

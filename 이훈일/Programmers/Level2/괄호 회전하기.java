import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            String subString = sb.substring(0, i);
            sb.delete(0, i);
            sb.append(subString);
            
            String ns = sb.toString();
            String[] words = ns.split("");
            Stack<String> stack = new Stack<>();
            boolean isPossible = true;
            for(String word : words) {
                if(word.equals("(") || word.equals("{") || word.equals("[")) {
                    stack.add(word);
                } else {
                    if(!stack.isEmpty()) {
                        if(stack.peek().equals("(") && word.equals(")")) {
                            stack.pop();
                        } else if(stack.peek().equals("{") && word.equals("}")) {
                            stack.pop();
                        } else if(stack.peek().equals("[") && word.equals("]")) {
                            stack.pop();
                        } else {
                            isPossible = false;
                        }
                    } else {
                        isPossible = false;
                    }
                }
            }
            
            if(isPossible && stack.isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
}

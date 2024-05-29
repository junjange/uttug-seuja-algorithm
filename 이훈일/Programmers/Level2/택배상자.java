import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> assistContainer = new Stack<>();
        int top = 0;
        int count = 0;
        for(int num : order) {
            if(num > top) {
                for(int i = top+1; i < num; i++) {
                    assistContainer.add(i);
                }
                
                top = num;
            } else {
                if(!assistContainer.isEmpty()) {
                    if(assistContainer.peek() == num) {
                        assistContainer.pop();
                    } else {
                        break;
                    }
                } 
            }
            count++;
        }
        
        return count;
    }
}

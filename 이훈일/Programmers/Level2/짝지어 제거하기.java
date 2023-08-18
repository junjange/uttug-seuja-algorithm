import java.util.Stack;

class Solution{
    public int solution(String s){
        Stack<String> stack = new Stack<>();

        String[] sArr = s.split("");
        for(String str : sArr) {
            if(stack.empty()) {
                stack.push(str);
            }else {
                if(stack.peek().equals(str)) {
                    stack.pop();
                }else {
                    stack.push(str);
                }
            }
        }

        return stack.size()==0?1:0;
    }
}

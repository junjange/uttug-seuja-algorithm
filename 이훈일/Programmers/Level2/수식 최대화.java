import java.util.*;

class Solution {
    static List<Long> nums;
    static List<String> folmulas;
    static String[] folmulaList = {"-", "+", "*"};
    static String[] result;
    static boolean[] visited;
    static long answer;
    
    public static long solution(String expression) {
        nums = new ArrayList<>();
        folmulas = new ArrayList<>();
        
        String num = "";
        for(int i = 0; i < expression.length(); i++) {
            char word = expression.charAt(i);
            if('0' <= word && word <= '9') {
                num += word;
            } else {
                nums.add(Long.parseLong(num));
                folmulas.add(String.valueOf(word));
                num = "";
            }
            
            if(i == expression.length()-1) {
                nums.add(Long.parseLong(num));
            }
        }
        
        answer = 0;
        visited = new boolean[3];
        result = new String[3];
        dfs(0);
        
        return answer;
    }
    
    public static void dfs(int depth) {
        if(depth == 3) {
            long num = Math.abs(cal());
            answer = Math.max(answer, num);
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(!visited[i]){
                result[depth] = folmulaList[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public static long cal() {
        List<Long> copiedNums = new ArrayList<>(nums);
        List<String> copiedFolmulas = new ArrayList<>(folmulas);
        
        for(String folmula : result) {
            for(int i = 0; i < copiedFolmulas.size(); i++) {
                if(copiedFolmulas.get(i).equals(folmula)) {
                    long num1 = copiedNums.remove(i);
                    long num2 = copiedNums.remove(i);

                    if(folmula.equals("*")) {
                        copiedNums.add(i, num1 * num2);
                    } else if(folmula.equals("+")) {
                        copiedNums.add(i, num1 + num2);
                    } else {
                        copiedNums.add(i, num1 - num2);
                    }

                    copiedFolmulas.remove(i);
                    i--;
                }
            }
        }
        
        return copiedNums.get(0);
    }
}

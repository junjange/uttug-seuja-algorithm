import java.util.*;

class Solution {
    String[] nums;
    boolean[] visited;
    HashSet<Integer> primeNums = new HashSet<>();
    
    public int solution(String numbers) {
        nums = numbers.split("");
        visited = new boolean[nums.length];
        
        dfs("", 0);
        
        return primeNums.size();
    }
    
    public void dfs(String number, int depth) {
        if(number.length() > 0) { 
            checkPrime(number);
        }
        
        if(depth == nums.length) {
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(number+nums[i], depth+1);
                visited[i] = false;
            }
        }
    }
    
    public void checkPrime(String number) {
        int num = Integer.parseInt(number);
        
        if(num <= 1) {
            return;
        }
        
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                return;
            }
        }
        
        primeNums.add(num);
    }
}

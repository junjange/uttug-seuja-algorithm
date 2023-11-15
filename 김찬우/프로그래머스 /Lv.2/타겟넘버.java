class Solution {
    
    static int count;
    
    public int solution(int[] numbers, int target) {
        
        count = 0;
        int answer;
        dfs(numbers,target,0,0);
        answer = count;
        
        return answer;
    }
    
    static void dfs(int[] numbers,int target, int depth, int sum){
        
        if(numbers.length == depth){
            if(sum == target){
                count++;
                
            }
            return;
        }
        
        int plus = numbers[depth] + sum;
        int minus = sum - numbers[depth];
        
        dfs(numbers,target,depth+1,plus);
        dfs(numbers,target,depth+1,minus);
        
    }
}

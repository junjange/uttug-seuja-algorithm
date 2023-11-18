class Solution {
    public static int[] numbers;
    public static int target;
    public static int count;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        count = 0;
        dfs(0, 0);
        return count;
    }
    
    public static void dfs(int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) {
                count++;
            }
            return;
        }
        
        int plusSum = sum + numbers[depth];
        int minusSum = sum - numbers[depth];
        
        dfs(depth + 1, plusSum);
        dfs(depth + 1, minusSum);
    }
}

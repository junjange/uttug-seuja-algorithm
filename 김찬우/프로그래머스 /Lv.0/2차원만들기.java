class Solution {
    public int[][] solution(int[] num_list, int n) {
        int count =0;
        
        int[][] answer = new int[num_list.length/n][n];
        
        for(int i =0; i<answer.length; i++ ){
            
            for(int j=0; j < answer[i].length;j++){
                
                answer[i][j] = num_list[count];
                count+=1;
            }
        }
        return answer;
    }
}

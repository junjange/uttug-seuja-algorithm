import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j != 0 && j != i) {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]); 
                }else if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == i){
                    triangle[i][j] += triangle[i-1][j-1];
                }
            }
        }
        int[] lastArray = triangle[triangle.length-1];
        Arrays.sort(lastArray);
        return lastArray[lastArray.length-1];
    }
}

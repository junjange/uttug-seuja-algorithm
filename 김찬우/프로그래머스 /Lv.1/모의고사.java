import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
        int[] result = {0,0,0};
        
         List<Integer> answer = new ArrayList<Integer>();
        
        for(int i=0;i<answers.length;i++){
            
            if(answers[i]==one[i%5]){
                result[0]++;
            }
            if(answers[i]==two[i%8]){
                result[1]++;
            }
            if(answers[i]==three[i%10]){
                result[2]++;
            }
            
            
            
            
        }
        
        int max = Math.max(result[0], Math.max(result[1], result[2]));
            
            for(int j = 0; j<3;j++){
                
                if(result[j] == max){
                    answer.add(j+1);
                }
            }
       
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = {0,0};
        int[] num = new int[n+1];
        
        List<String> list = new ArrayList<>();
        
        int i = 1;
        
        for(int j = 0; j<words.length; j++){
            
            if(i>n){
                i=1;
            }
            
            if(list.size()==0){
                list.add(words[j]);
                num[i]++;
                i++;
                continue;
            }
            
            if(list.contains(words[j])){
                answer[0]=i;
                answer[1]=num[i]+1;   
                break;
                
            }
            else if(list.get(list.size() - 1).charAt(list.get(list.size() - 1).length()-1) !=words[j].charAt(0)){
                answer[0]=i;
                answer[1]=num[i]+1;
                break;
            }
            
            list.add(words[j]);
            num[i]++;
            i++;
            
        }

        return answer;
    }
}

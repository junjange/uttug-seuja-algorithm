class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = {"aya", "ye", "woo", "ma"};
        String[] str1 = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for(int i=0; i<babbling.length; i++){
            
            for(int j=0; j<4; j++){
                
                if(babbling[i].contains(str1[j])){
                    break;
                }else{
                    babbling[i] = babbling[i].replace(str[j],"");
                }
                 
                
            }
            
            if( babbling[i].length() ==0){
                answer++;
            }
         
            
           
    
        }
        return answer;
    }
}

class Solution {
    public String solution(String cipher, int code) {
        
        String answer = "";
        
        for(int i = 1; i < cipher.length()+1; i++ ){
            
            if(i % code ==0){
                answer+= String.valueOf(cipher.charAt(i-1));
            }
        }
    
        return answer;
    }
}

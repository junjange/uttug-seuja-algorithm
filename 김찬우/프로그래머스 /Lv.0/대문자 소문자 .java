class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i =0; i < my_string.length() ; i++){
            
            char str = my_string.charAt(i);
            
            if(Character.isUpperCase(str)){
                answer+=String.valueOf(str).toLowerCase();   
            }
            else{
                answer+=String.valueOf(str).toUpperCase();     
            }
        }
        
        return answer;
    }
}

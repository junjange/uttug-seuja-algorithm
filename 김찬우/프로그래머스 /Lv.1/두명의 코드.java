class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String result = "";
        
        for(char i = 'a'; i <= 'z'; i++){
            
            if(!skip.contains(String.valueOf(i))){
                answer+=i;
            }
            
        }
        
        for(int i=0; i<s.length(); i++){
            
            int num = answer.indexOf(s.charAt(i));
            
            int leng = (num+index) % answer.length();
            result+= answer.charAt(leng);
            
        }
        
        
        
        return result;
    }
}

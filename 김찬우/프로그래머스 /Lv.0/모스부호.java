class Solution {
    public String solution(String letter) {
        String answer = "";
        
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        String[] morse = {".-","-...","-.-.","-..",".","..-.",
                   "--.","....","..",".---","-.-",".-..",
                   "--","-.","---",".--.","--.-",".-.",
                    "...","-","..-","...-",".--","-..-",
                    "-.--","--.."};
        
        String[] list = letter.split(" ");
        
        for(int i =0; i<list.length; i++){
            
            for(int j =0; j<morse.length; j++){
                
                if(list[i].equals(morse[j])){
                    answer+=alpha.charAt(j);
                }
            }
        }
        
        return answer;
    }
}

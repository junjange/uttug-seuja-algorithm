import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        
        String spel = String.join("", spell);
        
        char[] chars1 = spel.toCharArray();
        Arrays.sort(chars1);
        String sstr = new String(chars1);
               
        for(int i = 0 ; i < dic.length; i++){
            
            char[] chars2 = dic[i].toCharArray();
            Arrays.sort(chars2);
            String s2str = new String(chars2);
    
            if(s2str.equals(sstr)){
                return 1;
            }
           
        }
        
        return 2;
    }
}

import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        
        // 아이디어 
        // 문자열로 치환후 replaceFirst 사용
        
        // 시간 복잡도 
        // 바꿀 문자열이 없을 때 종료
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(int i=0; i<ingredient.length; i++){
            sb.append(ingredient[i]);
            
            if(sb.length() > 3 && sb.substring(sb.length()-4,sb.length()).equals("1231")){
                sb.delete(sb.length()-4,sb.length());
                count++;
            }
        }
        
    

        
        return count;
    }
}

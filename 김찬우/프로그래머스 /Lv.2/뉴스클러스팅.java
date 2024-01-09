import java.util.*;
class Solution {
    public int solution(String str1, String str2) {

        // 아이디어 
        // 두개씩 잘라서 배열에 넣고 비교 
        // 교집합 => 비교를 통한 숫자를 샌다
        // 합집합 =>
        // 교집합 and 합집합이 없다 , 공집합이면 1
        // 마지막에  65536 곱하고 소수점알 버린 정수부만 출력
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        int answer = 0;
      
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0; i<str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(('a'<= a && a <= 'z') && ('a'<= b && b <= 'z')){
                
                list1.add(""+a+b);
                
            }
            
        }
        
        for(int i=0; i<str2.length()-1; i++){
            
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if( ('a'<= a && a <= 'z') && ('a'<= b && b <= 'z')){
                
                list2.add(""+a+b);
                
            }
            
        }
        
        if (list1.size() == 0 && list2.size() == 0) {
			return 65536;
		}
        

        int max = list1.size() + list2.size();
        int min = 0; 
        
      
        
        for(String str : list1){
            
            for(int i=0; i<list2.size(); i++){
                
                if(str.equals(list2.get(i))){
                    min++;
                    list2.remove(i);
                    break;
                    
                }
                
            }
        }
        
        max = max - min;
        
        double result = (double)min/max;
        
        result*=65536;
        
       answer = (int)result;
        
        
        
        
        
        
        
        
        
        
        return answer;
    }
}

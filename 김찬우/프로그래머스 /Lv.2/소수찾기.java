import java.util.HashSet;
import java.util.Iterator;
import java.lang.Math;

class Solution {
    
    HashSet<Integer> numberset = new HashSet<>();
    
    public boolean isPrime(int num){
        
        if(num == 0 || num==1){
            return false;
        }
        
        int limit = (int)Math.sqrt(num);
        
        for(int i = 2; i<=limit;i++){
            
            if(num % i ==0){
                return false;
            }
            
        }
        
        return true;
         
        
    }
    
    public void recursive(String comb, String others){
        
          // 현재 조합을 set에 추가 
        if(!comb.equals("")){
            numberset.add(Integer.valueOf(comb));  
        }
       // 남은숫자 중 한개를 더해서 새로운 조합을 만든다.
        
        for(int i=0; i<others.length();i++){
            
            recursive(comb+others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }
        
    }
    
    
    
    public int solution(String numbers) {
        
        int count =0;
        
        // 모든 조합의 수를 만든다.
        
        recursive("",numbers);
        
        System.out.println(numberset);
        
        
        
        // 소수의 개수만 센다.
        
        
        Iterator<Integer> it = numberset.iterator();
        
        while(it.hasNext()){
            int number = it.next();
            if(isPrime(number)){
                count++;
            }
            
        }
        
        
        // 소수의 개수 반환. 
    
        return count;
    }
    
    
}

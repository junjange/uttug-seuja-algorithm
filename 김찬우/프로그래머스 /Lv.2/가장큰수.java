import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];  
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i< numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> { return (o2+o1).compareTo(o1+o2);});
        
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }
        
        String str = sb.toString();
        
        if(str.charAt(0) =='0'){
            return "0";
        }
        
        return str;
    }
}

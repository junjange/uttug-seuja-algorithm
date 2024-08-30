import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for(int i = 0; i < str1.length()-1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            
            if('A' <= first && first <= 'Z' && 'A' <= second && second <= 'Z') {
                set1.add("" + first + second);
            }
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            
            if('A' <= first && first <= 'Z' && 'A' <= second && second <= 'Z') {
                set2.add("" + first + second);
            }
        }
        
        Collections.sort(set1);
        Collections.sort(set2);
        
        for(String s : set1) {
            if(set2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        for(String s : set2) {  
			union.add(s);
		}
        
        double intersectionSize = intersection.size();
		double unionSize = union.size();
        
        double jakard = 0;
        if(unionSize == 0) {
            jakard = 1;
        } else {
            jakard = intersectionSize / unionSize;
        }
        
        return (int) (jakard * 65536);
    }
}

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String[] s1Spl = strSplit(s1);
                String[] s2Spl = strSplit(s2);
                
                if(s1Spl[0].equals(s2Spl[0])) {
                    int num1 = Integer.parseInt(s1Spl[1]);
                    int num2 = Integer.parseInt(s2Spl[1]);
                    return num1 - num2;
                } else {
                    return s1Spl[0].compareTo(s2Spl[0]);
                }
            }
        });
            
        return files;   
    }
    
    public String[] strSplit(String str) {
        String lower = str.toLowerCase();
        String[] strArr = new String[3];
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "";
        
        int idx = 0;
        for(int i = 0; i < str.length(); i++) {
            char word = lower.charAt(i);
            
            if(Character.isDigit(word)) {
                if(idx == 0) {
                    idx++;
                }
            } else {
                if(idx == 1) {
                    idx++;
                }
            }
            
            strArr[idx] += word;
        }
        
        return strArr;
    }
}

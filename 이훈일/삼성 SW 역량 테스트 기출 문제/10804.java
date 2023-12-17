import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static HashMap<String, String> map = new HashMap<String, String>() {{
    	put("b", "d");
        put("d", "b");
        put("p", "q");
        put("q", "p");
    }};
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String sentence = sc.next();
            String[] splitSen = sentence.split("");
            String answer = "";
            for(int i = splitSen.length-1; i >= 0; i--) {
            	answer += map.get(splitSen[i]);
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

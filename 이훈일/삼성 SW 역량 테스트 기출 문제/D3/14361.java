import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String N = sc.next();
            String[] nArr = N.split("");
            Arrays.sort(nArr);
            
            String answer = "impossible";
            int num = 2;
            String com = String.valueOf(Integer.parseInt(N) * num);
            while(N.length() == com.length()) {
                String[] comArr = com.split("");
            	Arrays.sort(comArr);
                answer = "possible";
                
                for(int i = 0; i < nArr.length; i++) {
                	if(!comArr[i].equals(nArr[i])) {
                    	answer = "impossible";
                        break;
                    }
                }
                
                if(answer.equals("possible")) {
                	break;
                } else {
                    num++;
                	com = String.valueOf(Integer.parseInt(N) * num);
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

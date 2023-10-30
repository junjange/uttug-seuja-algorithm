import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String word = sc.next();
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            int answer = 0;
            if(sb.toString().equals(sb.reverse().toString())) {
            	answer = 1;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

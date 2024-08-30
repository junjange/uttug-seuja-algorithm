import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            String answer = "No";
            for(int i = 1; i <= Math.sqrt(N); i++) {
            	if(N % i == 0) {
                	if(i < 10 && N/i < 10) {
                    	answer = "Yes";
                        break;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int d = sc.nextInt();
            int answer = 0;
            if(d >= 1000000) {
            	answer = 5;
            } else if(d >= 100000) {
            	answer = 4;
            } else if(d >= 10000) {
            	answer = 3;
            } else if(d >= 1000) {
            	answer = 2;
            } else if(d >= 100) {
            	answer = 1;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

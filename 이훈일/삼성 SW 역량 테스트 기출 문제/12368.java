import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
            int B = sc.nextInt();
            int time = 0;
            if(A + B >= 24) {
            	time = A + B - 24;
            }else {
            	time = A + B;
            }
            System.out.println("#" + test_case + " " + time);
		}
	}
}

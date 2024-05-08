import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int D = sc.nextInt();
            int L = sc.nextInt();
            int N = sc.nextInt();
            
            int sum = D;
            double percentage = L * 0.01;
            for(int i = 1; i < N; i++) {
            	sum += (i * percentage + 1) * D;
            }
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
}

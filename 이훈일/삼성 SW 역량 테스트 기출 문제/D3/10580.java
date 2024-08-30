import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int[][] lines = new int[N][2];
            for(int i = 0; i < N; i++) {
            	lines[i][0] = sc.nextInt();
                lines[i][1] = sc.nextInt();
            }
            
            int count = 0;
            for(int i = 0; i < N-1; i++) {
            	for(int j = i+1; j < N; j++) {
                	int a1 = lines[i][0];
                    int b1 = lines[i][1];
                    int a2 = lines[j][0];
                    int b2 = lines[j][1];
                    if((a1 < a2 && b2 < b1) || (a1 > a2 && b2 > b1)) {
                    	count++;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
            int size = (int) Math.pow(2, K) - 1;
            int[] trees = new int[size];
            for(int i = 0; i < size; i++) {
            	trees[i] = sc.nextInt();
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case + " ");
            for(int i = K-1; i >= 0; i--) {
            	for(int j = (int)Math.pow(2, i)-1; j < size; j += (int)Math.pow(2, i+1)) {
                    sb.append(trees[j] + " ");
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
		}
	}
}

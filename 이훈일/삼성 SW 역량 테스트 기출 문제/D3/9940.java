import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int[] num = new int[N];
            for(int i = 0; i < N; i++) {
            	num[i] = sc.nextInt();
            }
            
            Arrays.sort(num);
            
            int com = num[0];
            String answer = "Yes";
            for(int i = 0; i < N; i++) {
            	if(num[i] != com) {
                	answer = "No";
                    break;
                }
                com++;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

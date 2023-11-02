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
            int K = sc.nextInt();
            
            List<Integer> submitStudent = new ArrayList<Integer>();
            for(int i = 0; i < K; i++) {
            	submitStudent.add(sc.nextInt());
            }
            
            String answer = "#" + test_case;
            for(int i = 1; i <= N; i++) {
            	if(!submitStudent.contains(i)) {
                	answer = answer + " " + i;
                }
            }
			
            System.out.println(answer);
		}
	}
}

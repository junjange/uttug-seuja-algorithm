import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
            
            Stack<Integer> note = new Stack<>();
            for(int i = 0; i < K; i++) {
            	int amount = sc.nextInt();
                if(amount == 0) {
                	note.pop();
                } else {
                	note.add(amount);
                }
            }
            
            int sum = 0;
            int noteSize = note.size();
            for(int i = 0; i < noteSize; i++) {
            	sum += note.pop();
            }
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
}

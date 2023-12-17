import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
            int min = Integer.MAX_VALUE;
            int max = 0;
            
            for(int i = 0; i < 10; i++) {
                int sum = 0;       
                String numStr = sc.next();
                String[] numStrArr = numStr.split(""); 
                for(String num : numStrArr) {
                	sum += Integer.parseInt(num);
                }
                
                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }
            
            System.out.println("#" + test_case + " " + max + " " + min);
		}
	}
}

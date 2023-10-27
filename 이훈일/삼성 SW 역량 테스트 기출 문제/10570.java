import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
            int B = sc.nextInt();
            int count = 0;
            
            for(int i = A; i <= B; i++) {
                sb.append(String.valueOf(i));
                if(sb.toString().equals(sb.reverse().toString())) {
                	sb.setLength(0);
                    double sqrt = Math.sqrt(i);
                    if(sqrt == (int)sqrt) {
                    	sb.append(String.valueOf((int)sqrt));
                        if(sb.toString().equals(sb.reverse().toString())) {
                    		count++;
                    	}
                    }
                }
                sb.setLength(0);
            }
           
            System.out.println("#" + test_case + " " + count);
		}
	}
}

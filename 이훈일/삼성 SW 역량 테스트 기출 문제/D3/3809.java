import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            String[] nums = new String[N];
            for(int i = 0; i < N; i++) {
            	nums[i] = sc.next();
            }
            
            int num = 0;
            while(true) {
                String numStr = String.valueOf(num);
                boolean canMake = false;
            	for(int i = 0; i < N; i++) {
                    String comp = "";
                    for(int j = i; j < i+numStr.length(); j++) {
                        if(j < N) {
                        	comp += nums[j];
                        }
                    }
                    
                    if(comp.equals(numStr)) {
                        canMake = true;
                    	break;
                    }
                }
                
                if(!canMake) {
                	break;
                }
                num++;
            }
            
            System.out.println("#" + test_case + " " + num);
		}
	}
}

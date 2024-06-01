import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] box = new int[3];
            for(int i = 0; i < 3; i++) {
            	box[i] = sc.nextInt();
            }
            
            int answer = 0;
            if(box[1] == 1 || box[2] < 3) {
            	answer = -1;
            } else {
           		while(true) {
                	if(box[0] < box[1]) {
                    	if(box[1] < box[2]) {
                        	break;
                        } else {
                            answer++;
                        	box[1]--;
                        }
                    } else {
                        answer++;
                    	box[0]--;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

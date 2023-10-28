import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
        Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
            int testNum = sc.nextInt();
			Queue<Integer> que = new LinkedList<>();
            for(int i = 0; i < 8; i++) {
            	que.add(sc.nextInt());
            }
            
            Boolean isContinue = true; 
            while(isContinue) {
            	for(int i = 1; i <= 5; i++) {
                	if(que.peek() - i > 0) {
                    	que.add(que.poll() - i);
                    } else {
                    	que.poll();
                        que.add(0);
                        isContinue = false;
                        break;
                    }
                }
            }
            
            String answer = "#" + testNum;
            for(int i = 0; i < 8; i++) {
            	answer += " " + que.poll();
            }
            
            System.out.println(answer);
		}
	}
}

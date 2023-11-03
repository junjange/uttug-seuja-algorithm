import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int count = sc.nextInt();
            String secretNum = sc.next();
            String[] secret = secretNum.split("");
            
            Stack<String> stack = new Stack<>();
            for(String num : secret) {
            	if(stack.isEmpty()) {
                	stack.push(num);
                } else {
                	if(stack.peek().equals(num)) {
                		stack.pop();
               		} else {
                    	stack.push(num);
                    }
                }
            }
            
            String answer = "";
            int stackSize = stack.size();
            for(int i = 0; i < stackSize; i++) {
            	answer = stack.pop() + answer;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String line = sc.next();
            int[] numbers = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(numbers);
            
            Stack<Integer> note = new Stack<>();
            for(int num : numbers) {
            	if(note.isEmpty()) {
                	note.add(num);
                } else {
                	if(note.peek() == num) {
                    	note.pop();
                    } else {
                    	note.add(num);
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + note.size());
		}
	}
}

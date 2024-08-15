import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            
            int n = sc.nextInt();
            String str = sc.next();
            
            Stack<Character> stack = new Stack(); 
            
            for (int i=0; i<n; i++) {
                
               char word = str.charAt(i);
                
                if (stack.isEmpty()) {
                    stack.push(word);
                    continue;
                }
                
                if (stack.peek() == '{' && word == '}') {
                    stack.pop();
                }else if (stack.peek() == '[' && word == ']') {
                    stack.pop();
                }else if (stack.peek() == '(' && word == ')') {
                      stack.pop();   
                }else if (stack.peek() == '<' && word == '>') {
                    stack.pop();
                } else {
                     stack.push(word);
                
                }
            }
            
            if (stack.isEmpty()) {
                System.out.println("#"+test_case+" "+1);
            }else {
                  System.out.println("#"+test_case+" "+0);
            }
            

		}
	}
}

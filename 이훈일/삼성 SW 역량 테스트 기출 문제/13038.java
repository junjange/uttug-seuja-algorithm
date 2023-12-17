import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            
            int[] week = new int[7]; 
            for(int i = 0; i < 7; i++) {
            	week[i] = sc.nextInt();
            }
            
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 7; i++)  {
            	if(week[i] == 1) {
                    int first = i;
                	int count = 0;
                    while(true) {
                    	if(week[first % 7] == 1) {
                        	count++;
                        }
                        
                        first++;
                        if(count == n) {
                        	min = Math.min(min, first - i);
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + min);
		}
	}
}

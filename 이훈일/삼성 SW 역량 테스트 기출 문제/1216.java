import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static String[][] arr;
    
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			int caseNum = sc.nextInt();
            
            arr = new String[100][100];
            for(int i = 0; i < 100; i++) {
                arr[i] = sc.next().split("");
            }
            
            int maxLen = 0;
            loop1:
            for(int len = 100; len >= 1; len--) {
                loop2:
            	for(int i = 0; i < 100; i++) {
                    loop3:
                	for(int j = 0; j < 100; j++) {
                    	if(isPalindromeLength(i, j, len) || isPalindromeWidth(i, j, len)) {
                        	maxLen = len;
                            break loop1;
                        }
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + maxLen);
		}
	}
    
    public static Boolean isPalindromeLength(int x, int y, int len) {
        if(x + len > 100) {
        	return false;
        } 
        StringBuilder sb = new StringBuilder();
        for(int i = x; i < x+len; i++) {
        	sb.append(arr[i][y]);
        }
        if(sb.toString().equals(sb.reverse().toString())) {
        	return true;
        }
        return false;
    }
    
    public static Boolean isPalindromeWidth(int x, int y, int len) {
    	if(y + len > 100) {
        	return false;
        } 
        StringBuilder sb = new StringBuilder();
        for(int i = y; i < y+len; i++) {
        	sb.append(arr[x][i]);
        }
        if(sb.toString().equals(sb.reverse().toString())) {
        	return true;
        }
        return false;
    }
}

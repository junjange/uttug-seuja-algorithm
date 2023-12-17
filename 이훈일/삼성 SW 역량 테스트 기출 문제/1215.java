import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static String[][] arr;
    public static int len;
    
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			len = sc.nextInt();
            arr = new String[8][8];
            for(int i = 0; i < 8; i++) {
                arr[i] = sc.next().split("");
            }
            
            int count = 0;
            for(int i = 0; i < 8; i++) {
            	for(int j = 0; j < 8; j++) {
                	if(isPalindromeLength(i, j)) {
                    	count++;
                    }
                    if(isPalindromeWidth(i, j)) {
                    	count++;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
    
    public static Boolean isPalindromeLength(int x, int y) {
        if(x > 8-len) {
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
    
    public static Boolean isPalindromeWidth(int x, int y) {
    	if(y > 8-len) {
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

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
        Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int side = sc.nextInt();
            int[][] arr = new int[side][side]; 
            for(int i = 0; i < side; i++) {
            	for(int j = 0; j < side; j++) {
                	arr[i][j] = sc.nextInt();
                }
            }
            
            int count = 0;
            for(int i = 0; i < side; i++) {
            	for(int j = 0; j < side; j++) {
                	if(arr[i][j] == 1) {
                    	for(int k = i; k < side; k++) {
                        	if(arr[k][j] == 2) {
                            	arr[k][j] = 0;
                                count++;
                                break;
                            } else if(arr[k][j] == 1) {
                            	arr[k][j] = 0;
                            }
                        }
                    } else if(arr[i][j] == 2) {
                    	for(int k = i; k >= 0; k--) {
                        	if(arr[k][j] == 1) {
                            	arr[k][j] = 0;
                                count++;
                                break;
                            } else if(arr[k][j] == 2) {
                            	arr[k][j] = 0;
                            }
                        }
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}

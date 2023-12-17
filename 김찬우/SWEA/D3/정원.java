import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n= sc.nextInt();
            int d = sc.nextInt();
            int leat = (2*d)+1;
            int share = n/leat;
            int result = n%leat;
            
            
            if(result == 0){
                System.out.println("#"+test_case+" "+share);
            }else{
                System.out.println("#"+test_case+" "+(share+1));
            }
            
            
		
		

		}
	}
}

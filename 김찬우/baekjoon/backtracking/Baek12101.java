
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static ArrayList<String> result;
    static int[] arr;
    static long k;
    static String answer = null ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[3];
        result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            arr[i] = i+1;
        }

        back(0,0,"");
        if (answer != null) {
            System.out.println(answer);
        }else {
            System.out.println(-1);
        }


    }
    static void back(int depth, int sum, String s) {

        if (n == sum) {
            k++;
            if (k == m) {

                answer = s.substring(0,s.length()-1);
            }

            return;
        }

        if (depth == n) {
            return;
        }

        for (int i = 0; i < 3; i++) {

            back(depth+1,sum + arr[i],s + (arr[i]+"+"));

        }

    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static long max = -1;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];


        st = new StringTokenizer(br.readLine());

        arr[0] = 0;
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0,1,0);

        System.out.println(max);


    }

    static void back(int depth, long sum, int sec) {

        if (depth >= n) {
            max = Math.max(max, sum);
            return;
        }

        if (sec == m) {
            max = Math.max(max, sum);
            return;
        }
        

        if (depth <= n-1) {
            back(depth+1,sum + arr[depth+1],sec + 1);
        }

        if (depth <= n-2) {
            back(depth+2,sum/2 + arr[depth+2],sec + 1);
        }


    }
}

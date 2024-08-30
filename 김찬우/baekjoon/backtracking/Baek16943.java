import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String input;
    static String result;
    static int[] arr;
    static boolean[] visited;
    static int len;
    static int min = Integer.MAX_VALUE;
    static int answer;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        input = st.nextToken();
        result = st.nextToken();
        len = input.length();

        arr = new int[len];
        visited = new boolean[len];

        for (int i=0; i<len; i++) {
            arr[i] = input.charAt(i) - '0';
        }
        back(0,"");

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }




    }
    static void back(int depth, String sum) {

        if (depth == len) {

            if (sum.charAt(0)=='0') {
                return;
            }

            if (Integer.parseInt(sum) < Integer.parseInt(result)) {

                int abs = Math.abs(Integer.parseInt(result) - Integer.parseInt(sum));

                if (min > abs) {
                    min = abs;
                    answer = Integer.parseInt(sum);
                }

                return;

            }


            return;
        }

        for (int i=0; i<len; i++) {
            if (!visited[i]) {
               visited[i] =true;
               back(depth+1,sum+arr[i]);
               visited[i] = false;
            }
        }
    }
}

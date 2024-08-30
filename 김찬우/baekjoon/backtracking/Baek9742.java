

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static boolean[] visited;
    static String input;
    static int index;
    static int len;
    static int k;
    static String result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line=br.readLine())!=null) {

            StringTokenizer st = new StringTokenizer(line);

            input = st.nextToken();
            index = Integer.parseInt(st.nextToken());

            len = input.length();
            result = null;

            arr = new char[len];
            visited = new boolean[len];
            k=0;


            back(0);

            if (result == null) {
                System.out.println(input+" "+index+" = No permutation");
            }else {
                System.out.println(input+" "+index+" = "+result);
            }


        }

    }

    static void back(int depth) {

        if (depth == len) {

            k++;

            if (index == k) {
                result = new String(arr);
                return;

            }

            return;
        }

        for (int i=0; i < len; i++) {

            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = input.charAt(i);
                back(depth+1);
                visited[i] = false;
            }
        }
    }
}

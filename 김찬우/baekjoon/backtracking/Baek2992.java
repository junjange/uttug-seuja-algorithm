
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<String> result;
    static HashSet<String> set = new HashSet<>();
    static String str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        n = str.length();
        arr = new int[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++) {
            arr[i] = str.charAt(i)-'0';
        }

        back(0,"");

        result = new ArrayList<>(set);

        Collections.sort(result);


        int index = result.indexOf(str);

        if (index == result.size() - 1) {
            System.out.println(0);
        }else {
            System.out.println(result.get(index+1));
        }


    }

    static void back(int depth, String sum) {

        if (depth == n) {
            set.add(sum);
            return;
        }

        for (int i=0; i<n; i++) {

            if (!visited[i]) {
                visited[i] = true;
                back(depth+1,sum+arr[i]);
                visited[i] = false;
            }
        }
    }

}


import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static int n,m;
    static ArrayList<Integer> list;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        list = new ArrayList<>(set);

        if (set.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);

        for (int a : list) {
            System.out.print(a+" ");
        }


    }

    static void backTracking(int depth) {

        if (depth == m ) {
            int sum = 0;

            for (int i=0; i<m; i++) {
                sum+=result[i];
            }

            if (isPrime(sum)) {
                set.add(sum);
            }

            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int num) {


        if (num == 2) {
            return true;
        }

        for (int i=2; i*i <=num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }
}

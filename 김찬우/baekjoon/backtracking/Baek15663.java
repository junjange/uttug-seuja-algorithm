
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;
    static int n,m;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        // 아이디어 셋으로 중목을 제거 한후 중복을 허용해서 m개를 뽑는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        rec(0);

        System.out.println(sb);

    }

    public static void rec(int depth){

        if(depth==m){

            for(int i=0; i<m;i++){
                sb.append(result[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        int before = 0;

        for(int i=0 ;i<n; i++){

            if(visited[i]){
                continue;
            }

            if(before != arr[i]){
                visited[i] = true;
                before = arr[i];
                result[depth] = arr[i];
                rec(depth+1);
                visited[i] = false;
            }

        }


    }


}

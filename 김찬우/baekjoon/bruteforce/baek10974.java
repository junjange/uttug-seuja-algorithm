
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        // 아이디어
        // 배열을 만들어주고 for를 전부 돌면서 rec depth가 n 일때 종류

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        rec(0);
        System.out.println(sb);


    }

    public static void rec(int depth){

        if(depth == n){
            for(int i=0; i<n; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){

            if(!visited[i]){

                visited[i] =true;
                result[depth] = arr[i];
                rec(depth+1);
                visited[i] =false;

            }



        }
    }
}

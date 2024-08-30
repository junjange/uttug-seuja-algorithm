
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {

    static int n,k;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb =new StringBuilder();

    static HashSet<Long> set = new HashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        result = new int[k];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        backTracking(0);

        System.out.println(set.size());

    }

    static void backTracking(int depth){

        if(depth == k){

            sb.setLength(0);


            for(int i=0; i<k; i++){

                sb.append(result[i]);

            }

            set.add(Long.valueOf(sb.toString()));
            return;
        }

        for(int i=0; i<n; i++){

            if(!visited[i]){
                visited[i] = true;
                result[depth] =arr[i];
                backTracking(depth+1);
                visited[i] = false;

            }


        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {

        // 아이디어
        // 바구니를 배열로 표현 for문을 돌면서 없으면 넣고 있을 때 처리

        // 시간 복잡도 100*100

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        for(int p=0; p<m; p++){

            st = new StringTokenizer(br.readLine(), " ");

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int i = left; i<=right; i++){
                arr[i] = k;
            }


        }

        for(int i=1; i<=n; i++){
            System.out.print(arr[i]+" ");
        }


    }
}

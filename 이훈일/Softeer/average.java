import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] students = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double start = Double.parseDouble(st.nextToken());
            double end = Double.parseDouble(st.nextToken());
            
            double sum = 0;
            for(double j = start - 1; j < end; j++) {
                sum += students[(int) j];
            }
            System.out.println(String.format("%.2f", sum / (end - start + 1)));
        }
    }
}

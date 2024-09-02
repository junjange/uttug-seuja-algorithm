
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int sec = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < l; j++) {
                list.add(0);
            }

            for (int j = 0; j < 5; j++) {
                list.add(1);
            }

        }
        while (true) {

            if (sec >= list.size()) {
                break;
            }

            if (list.get(sec) == 1){
                break;
            }

            sec += d;

        }
        System.out.println(sec);



    }
}
